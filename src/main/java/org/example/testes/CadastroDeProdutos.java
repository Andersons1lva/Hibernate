package org.example.testes;

import org.example.dao.ProdutoDao;
import org.example.modelo.Categoria;
import org.example.modelo.Produto;
import org.example.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CadastroDeProdutos {
    public static void main(String[] args) {
        Produto celular = new Produto("Mi 9T",
                "Top demais",
                new BigDecimal("1.900"),
                Categoria.CELULAR);


        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao dao = new ProdutoDao(em);

        em.getTransaction().begin();
        dao.cadastrar(celular);
        em.getTransaction().commit();
        em.close();
    }
}
