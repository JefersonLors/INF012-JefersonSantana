package com.loja.loja_ms.dtos;

import java.time.LocalDateTime;

public record ProductReportDto(String name, String category, long inventory, double price, LocalDateTime ctr_dth_updt) {
}
