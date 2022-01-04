package com.birulino.backend_completo.models;

import lombok.Data;

@Data
public class Product {
  private Integer id;
  private String name;
  private Integer quantity;
  private Double value;
  private String observation;
}
