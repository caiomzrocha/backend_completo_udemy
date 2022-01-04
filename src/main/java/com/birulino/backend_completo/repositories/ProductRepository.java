package com.birulino.backend_completo.repositories;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import com.birulino.backend_completo.models.Product;

import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {
  private List<Product> products = new ArrayList<Product>();
  private Integer lastId = 0;

  /**
   * Método para retornar uma lista com todos os produtos.
   * @return lista de produtos
   */
  public List<Product> getAll() {
    return products;
  }

  /**
   * Busca um produto pelo id
   * @param id do produto
   * @return produto ou null caso não seja encontrado
   */
  public Optional<Product> findById(Integer id) {
    return products.stream().filter(p -> p.getId() == id).findFirst();
  }

  /**
   * Adiciona um produto no banco de dados
   * @param product a ser adicionado
   * @return produto adicionado
   */
  public Product add(Product product) {
    product.setId(lastId++);
    products.add(product);
    return product;
  }

  /**
   * Remove um determinado produto do banco de dados
   * @param id do produto a ser removido
   */
  public void delete(Integer id) {
    products.removeIf(p -> p.getId() == id);
  }

  /**
   * Atualiza um determinado produto no banco de dados
   * @param product a ser atualizado
   * @return produto atualizado
   */
  public Product update(Product product) {
    Optional<Product> productToUpdate = findById(product.getId());

    if(productToUpdate.isEmpty()) {
      throw new InputMismatchException("Produto não encontrado.");
    }
    
    delete(product.getId());
    products.add(product);
    return product;
  }
}
