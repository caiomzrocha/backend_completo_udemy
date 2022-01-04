package com.birulino.backend_completo.services;

import java.util.List;
import java.util.Optional;

import com.birulino.backend_completo.models.Product;
import com.birulino.backend_completo.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

  @Autowired
  private ProductRepository productRepository;

  /**
   * Método para retornar uma lista com todos os produtos.
   * @return lista de produtos
   */
  public List<Product> getAll() {
    return productRepository.getAll();
  }

  /**
   * Busca um produto pelo id
   * @param id do produto
   * @return produto ou null caso não seja encontrado
   */
  public Optional<Product> findById(Integer id) {
    return productRepository.findById(id);
  }

  /**
   * Adiciona um produto no banco de dados
   * @param product a ser adicionado
   * @return produto adicionado
   */
  public Product add(Product product) {
    return productRepository.add(product);
  }

  /**
   * Serviço para remover um determinado produto do banco de dados
   * @param id do produto a ser removido
   */
  public void delete(Integer id) {
    productRepository.delete(id);
  }

  /**
   * Atualiza um determinado produto no banco de dados
   * @param id do produto a ser atualizado
   * @param product a ser atualizado
   * @return
   */
  public Product update(Integer id, Product product) {
    product.setId(id);
    return productRepository.update(product);
  }
}
