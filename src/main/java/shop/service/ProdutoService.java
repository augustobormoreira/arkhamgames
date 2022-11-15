package shop.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import shop.model.Produto;
import shop.model.User;
import shop.model.Client;
import shop.repository.ProdutoRepository;
import shop.repository.UserRepository;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private UserRepository userRepository;

    double a = 0;

    int posicao = 0; //Armazena a posicao do item dentro do array de lista de desejos

    public Produto compraProduto(long idProduto, String cpf) {

        Optional<Produto> produtoExistente = produtoRepository.findById(idProduto);
        Optional<User> userExistente = userRepository.findById(cpf);

        if(produtoExistente.isPresent() && userExistente.isPresent() && !(produtoExistente.get().getPedidos().isEmpty())) {

            //Adicionar o produto ao carrinho do cliente
            userExistente.get().getCarrinho().add(produtoExistente.get());

            //Remover o produto da lista de desejos do cliente
            userExistente.get().getListaDeDesejos().remove(posicao);

            int contadorProduto = 0;

            //Navega no ArrayList de pedidos do produto
            for(int i = 0; i < produtoExistente.get().getPedidos().size(); i++) {

                //Verifica se o produto ja foi comprado pelo cliente
                if(produtoExistente.get().getPedidos().get(i).getCpf().equals(cpf)) {
                    contadorProduto++;
                }
            }

            //Se o produto ja foi comprado pelo cliente, nao adiciona o produto ao carrinho
            if(contadorProduto > 1) {
                produtoExistente.get().getPedidos().remove(clienteExistente.get());
            }

            //Se o produto nao foi comprado pelo cliente, adiciona o produto ao carrinho
            else {
                //Adiciona o produto ao carrinho
                userExistente.get().getCarrinho().add(produtoExistente.get());

                //Adiciona o produto ao historico de compras do cliente
                userExistente.get().getHistoricoCompras().add(produtoExistente.get());

                //Adiciona o cliente ao historico de compras do produto
                produtoExistente.get().getHistoricoCompras().add(userExistente.get());

                //Atualiza o produto no banco de dados
                produtoRepository.save(produtoExistente.get());

                //Atualiza o cliente no banco de dados
                userRepository.save(userExistente.get());
            }
        }
    }
}

