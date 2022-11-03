package br.com.act.rbmq.springboot.service.dtos;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class ProductDTO implements Serializable {

    private Integer id;
    private String name;

    public ProductDTO() {}

    public ProductDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
