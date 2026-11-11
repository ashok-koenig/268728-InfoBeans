package com.example.enrollment.security

import com.example.enrollment.config.AppProperties
import org.springframework.stereotype.Service
import tools.jackson.databind.ObjectMapper
import java.nio.charset.StandardCharsets
import java.security.MessageDigest
import java.time.Instant
import java.util.Base64
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

@Service
class TokenService(private val props: AppProperties, private val mapper: ObjectMapper) {

    fun issue(student: String, role: String): String {
        val exp = Instant.now().plusSeconds(props.tokenMinutes * 60).epochSecond
        val payload = """{"sub":"$student","role":"$role","exp":$exp}"""
        val unsigned = encode(HEADER) + "." + encode(payload)
        return unsigned + "." + sign(unsigned)
    }

    fun verify(token: String): AuthUser? {
        return try {
            val parts = token.split(".")
            if (parts.size != 3) return null
            val expected = sign(parts[0] + "." + parts[1])
            if (!MessageDigest.isEqual(expected.toByteArray(), parts[2].toByteArray())) return null
            val claims = mapper.readTree(String(Base64.getUrlDecoder().decode(parts[1]), StandardCharsets.UTF_8))
            if (claims.get("exp").asLong() < Instant.now().epochSecond) return null
            AuthUser(claims.get("sub").asString(), claims.get("role").asString())
        } catch (e: RuntimeException) {
            null
        }
    }

    private fun sign(text: String): String {
        val mac = Mac.getInstance("HmacSHA256")
        mac.init(SecretKeySpec(props.jwtSecret.toByteArray(), "HmacSHA256"))
        return Base64.getUrlEncoder().withoutPadding().encodeToString(mac.doFinal(text.toByteArray()))
    }

    private fun encode(json: String): String = Base64.getUrlEncoder().withoutPadding().encodeToString(json.toByteArray())

    companion object {
        private const val HEADER = """{"alg":"HS256","typ":"JWT"}"""
    }
}
