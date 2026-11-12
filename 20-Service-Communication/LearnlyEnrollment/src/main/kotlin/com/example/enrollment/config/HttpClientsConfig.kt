package com.example.enrollment.config

import com.example.enrollment.adapter.CatalogueClient
import org.springframework.context.annotation.Configuration
import org.springframework.web.service.registry.ImportHttpServices

@Configuration
@ImportHttpServices(group = "catalogue", types = [CatalogueClient::class])
class HttpClientsConfig