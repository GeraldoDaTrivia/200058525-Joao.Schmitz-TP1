import java.util.Scanner;

public class TP1 {
	
//Variáveis
	static int opçaoMenu, numClientes=0, numProdutos=0;
	static String nomeCliente[] = new String[999];
	static String endCliente[] = new String[999];
	static String telCliente[] = new String[999];
	static String nomeProduto[] = new String[999];
	static String descProduto[] = new String[999];
	static double valorProduto[] = new double[999];
	static double porcLucro[] = new double[999];
	static int quantEstoque[] = new int[999];
	
//Scanner
	static Scanner sc = new Scanner(System.in);
	
//Métodos
	public static void main(String[] args) {
		
	//Dados pré-carregados (Clientes)
		for(int cont = 0; cont < 10; cont++) {
			nomeCliente[numClientes] = "Cliente "+numClientes;
			endCliente[numClientes] = "Rua "+numClientes;
			telCliente[numClientes] = "9813000"+numClientes;
			
			numClientes++;
		}

	//Dados pré-carregados (Produtos)
		for(int cont = 0; cont < 10; cont++) {
			nomeProduto[numProdutos] = "Produto "+numProdutos;
			descProduto[numProdutos] = "Descrição "+numProdutos;
			valorProduto[numProdutos] = ((numProdutos+1)*9.99);
			porcLucro[numProdutos] = (numProdutos+17);
			quantEstoque[numProdutos] = ((numProdutos+1)*100);
			
			numProdutos++;
		}
		
		do {
			//Menu
			System.out.println("======================================================================");
			System.out.println("1. Cadastro de novo cliente.");
			System.out.println("2. Busca por cliente.");
			System.out.println("3. Cadastro de novo produto.");
			System.out.println("4. Busca por produto.");
			System.out.println("5. Cadastro de venda.");
			System.out.println("6. Mostrar produtos em estoque.");
			System.out.println("7. Sair.");
			System.out.println("======================================================================");
			
			//Receber opção
			System.out.println("Qual opção deseja realizar ?");
			opçaoMenu = sc.nextInt();
			
			//Operações
			switch(opçaoMenu) {
				case 1:
					cadastroCliente();
					break;
				case 2:
					buscarCliente();
					break;
				case 3:
					cadastroProduto();
					break;
				case 4:
					buscarProduto();
					break;
				case 5:
					cadastroVenda();
					break;
				case 6:
					produtosEstoque();
					break;
				case 7:
					System.out.println("...");
					System.out.println("O programa foi encerrado.");
					break;
				default:
					System.out.println("----------------------------------------------------------------------");
					System.out.println("Opção inválida. Por favor escolher opção válida.");
					break;
			}
		} while(opçaoMenu != 7);
		
	}
	
	public static void cadastroCliente() {
		
		int quantCadastros, cont;

		//Quantidade de cadastros
		System.out.println("----------------------------------------------------------------------");
		System.out.println("Quantos clientes serão cadastrados ?");
		quantCadastros = sc.nextInt();
		if(quantCadastros > 0) {
			//Cadastro de dados
			System.out.println("Informe os dados dos clientes para o cadastro.");
			sc.nextLine();
			for(cont = 0; cont < quantCadastros; cont++) {
				System.out.println("----------------------------------------------------------------------");
				System.out.println("Nome do cliente:");
				nomeCliente[numClientes] = sc.nextLine();
				System.out.println("Endereço do cliente:");
				endCliente[numClientes] = sc.nextLine();
				System.out.println("Telefone do cliente:");
				telCliente[numClientes] = sc.nextLine();
				
				numClientes++;
			}
		} else {
			System.out.println("Quantidade inválida.");
		}
		//Fim de operação
		System.out.println("...");
		System.out.println("Retornando ao menu.");
	}
	
	public static void buscarCliente() {
		
		int cont, escolhaAlt, mudarDados, novaBusca, nomesIguais;
		String nomeBusca;
		
		do {
			nomesIguais = 0;
			//Receber o nome para busca
			sc.nextLine();
			System.out.println("----------------------------------------------------------------------");
			System.out.println("Digite o nome do cliente para busca:");
			nomeBusca = sc.nextLine();
			System.out.println("----------------------------------------------------------------------");
			
			//Verificação de clientes
			for(cont = 0; cont < numClientes; cont++) {
				if(nomeBusca.equals(nomeCliente[cont])) {
					//Mostrar os dados obtidos
					System.out.println("Nome: " + nomeCliente[cont]);
					System.out.println("Endereço: " + endCliente[cont]);
					System.out.println("Telefone: " + telCliente[cont]);
					
					do {
						//Escolher se irá mudar os dados
						System.out.println("----------------------------------------------------------------------");
						System.out.println("Deseja realizar mudanças nos dados deste cliente ?");
						System.out.println("1. Sim.");
						System.out.println("2. Não.");
						mudarDados = sc.nextInt();
						switch(mudarDados) {
							//Alterar dados
							case 1:
								do {
									System.out.println("----------------------------------------------------------------------");
									System.out.println("Qual dado deseja alterar ?");
									System.out.println("1. Nome.");
									System.out.println("2. Endereço.");
									System.out.println("3. Telefone.");
									System.out.println("4. Terminar alterações.");
									escolhaAlt = sc.nextInt();
									sc.nextLine();
									switch(escolhaAlt) {
										//Alteração de nome
										case 1:
											System.out.println("----------------------------------------------------------------------");
											System.out.println("Digite o novo nome:");
											nomeCliente[cont] = sc.nextLine();
											break;
										//Alteração de endereço
										case 2:
											System.out.println("----------------------------------------------------------------------");
											System.out.println("Digite o novo endereço:");
											endCliente[cont] = sc.nextLine();
											break;
										//Alteração de telefone
										case 3:
											System.out.println("----------------------------------------------------------------------");
											System.out.println("Digite o novo telefone:");
											telCliente[cont] = sc.nextLine();
											break;
										//Fim das alterações
										case 4:
											System.out.println("----------------------------------------------------------------------");
											System.out.println("Dados salvos.");
											mudarDados = 2;
											break;
										//Opção inválida
										default:
											System.out.println("----------------------------------------------------------------------");
											System.out.println("Opção inválida. Por favor escolher opção válida.");
											break;
									}
								} while(escolhaAlt != 4);
								break;
							//Não alterar dados
							case 2:
								System.out.println("----------------------------------------------------------------------");
								System.out.println("Dados salvos.");
								break;
							//Opção inválida
							default:
								System.out.println("----------------------------------------------------------------------");
								System.out.println("Opção inválida. Por favor escolher opção válida.");
								break;
						}
					} while(mudarDados != 2);
					
					nomesIguais++;
				}
			}
			//Caso não tiver nomes correspondentes
			if(nomesIguais==0) {
				System.out.println("Cliente não encontrado!");
			}
			//Repetir a busca
			System.out.println("----------------------------------------------------------------------");
			System.out.println("Deseja realizar outra busca ?");
			System.out.println("1. Sim.");
			System.out.println("2. Voltar ao menu.");
			novaBusca = sc.nextInt();
		} while(novaBusca == 1);
		//Fim de operação
		System.out.println("...");
		System.out.println("Retornando ao menu.");
	}
	
	public static void cadastroProduto() {
		
		int quantCadastros, cont;

		//Quantidade de cadastros
		System.out.println("Quantos produtos serão cadastrados ?");
		quantCadastros = sc.nextInt();
		if(quantCadastros > 0) {
			//Cadastro de dados
			System.out.println("Informe os dados dos produtos para o cadastro.");
			for(cont = 0; cont < quantCadastros; cont++) {
				sc.nextLine();
				System.out.println("----------------------------------------------------------------------");
				System.out.println("Nome do produto:");
				nomeProduto[numProdutos] = sc.nextLine();
				System.out.println("Descrição do produto:");
				descProduto[numProdutos] = sc.nextLine();
				System.out.println("Valor de compra do produto:");
				valorProduto[numProdutos] = sc.nextDouble();
				System.out.println("Porcentagem de lucro do produto:");
				porcLucro[numProdutos] = sc.nextDouble();
				System.out.println("Quantidade em estoque do produto:");
				quantEstoque[numProdutos] = sc.nextInt();
				
				numProdutos++;
			}
		} else {
			System.out.println("Quantidade inválida.");
		}
		//Fim de operação
		System.out.println("...");
		System.out.println("Retornando ao menu.");
	}
	
	public static void buscarProduto() {
		
		int cont, escolhaAlt, mudarDados, novaBusca, nomesIguais;
		String nomeBusca;
		
		do {
			nomesIguais = 0;
			//Receber o nome para busca
			sc.nextLine();
			System.out.println("----------------------------------------------------------------------");
			System.out.println("Digite o nome do produto para busca:");
			nomeBusca = sc.nextLine();
			System.out.println("----------------------------------------------------------------------");
			
			//Verificação de produtos
			for(cont = 0; cont < numProdutos; cont++) {
				if(nomeBusca.equals(nomeProduto[cont])) {
					//Mostrar os dados obtidos
					System.out.println("Nome: " + nomeProduto[cont]);
					System.out.println("Descrição: " + descProduto[cont]);
					System.out.printf("Valor de compra: R$%.2f\n", valorProduto[cont]);
					System.out.println("Porc. de lucro: " + porcLucro[cont] + "%");
					System.out.println("Quant. em estoque: " + quantEstoque[cont]);
					
					do {
						//Escolher se irá mudar os dados
						System.out.println("----------------------------------------------------------------------");
						System.out.println("Deseja realizar mudanças nos dados deste produto ?");
						System.out.println("1. Sim.");
						System.out.println("2. Não.");
						mudarDados = sc.nextInt();
						switch(mudarDados) {
							//Alterar dados
							case 1:
								do {
									System.out.println("----------------------------------------------------------------------");
									System.out.println("Qual dado deseja alterar ?");
									System.out.println("1. Nome.");
									System.out.println("2. Descrição.");
									System.out.println("3. Valor de compra.");
									System.out.println("4. Porcentagem de lucro.");
									System.out.println("5. Quantidade em estoque.");
									System.out.println("6. Terminar alterações.");
									escolhaAlt = sc.nextInt();
									sc.nextLine();
									switch(escolhaAlt) {
										//Alteração de nome
										case 1:
											System.out.println("----------------------------------------------------------------------");
											System.out.println("Digite o novo nome:");
											nomeProduto[cont] = sc.nextLine();
											break;
										//Alteração de descrição
										case 2:
											System.out.println("----------------------------------------------------------------------");
											System.out.println("Digite a nova descrição:");
											descProduto[cont] = sc.nextLine();
											break;
										//Alteração de valor de compra
										case 3:
											System.out.println("----------------------------------------------------------------------");
											System.out.println("Digite o novo valor de compra:");
											valorProduto[cont] = sc.nextDouble();
											break;
										//Alteração de porcentagem de lucro
										case 4:
											System.out.println("----------------------------------------------------------------------");
											System.out.println("Digite a nova porcentagem de lucro:");
											porcLucro[cont] = sc.nextDouble();
											break;
										//Alteração de quantidade em estoque
										case 5:
											System.out.println("----------------------------------------------------------------------");
											System.out.println("Digite a nova quantidade no estoque:");
											quantEstoque[cont] = sc.nextInt();
											break;
										//Fim das alterações
										case 6:
											System.out.println("----------------------------------------------------------------------");
											System.out.println("Dados salvos.");
											mudarDados = 2;
											break;
										//Opção inválida
										default:
											System.out.println("----------------------------------------------------------------------");
											System.out.println("Opção inválida. Por favor escolher opção válida.");
											break;
									}
								} while(escolhaAlt != 6);
								break;
							//Não alterar dados
							case 2:
								System.out.println("----------------------------------------------------------------------");
								System.out.println("Dados salvos.");
								break;
							//Opção inválida
							default:
								System.out.println("----------------------------------------------------------------------");
								System.out.println("Opção inválida. Por favor escolher opção válida.");
								break;
						}
					} while(mudarDados != 2);
					
					nomesIguais++;
				}
			}
			//Caso não tiver nomes correspondentes
			if(nomesIguais==0) {
				System.out.println("Produto não encontrado!");
			}
			//Repetir a busca
			System.out.println("----------------------------------------------------------------------");
			System.out.println("Deseja realizar outra busca ?");
			System.out.println("1. Sim.");
			System.out.println("2. Voltar ao menu.");
			novaBusca = sc.nextInt();
		} while(novaBusca == 1);
		//Fim de operação
		System.out.println("...");
		System.out.println("Retornando ao menu.");
	}

	public static void cadastroVenda() {
		
		int cont, clienteEscolhido, produtoEscolhido, quantVendida, quantValida;
		
		do {
			//Lista de clientes
			System.out.println("----------------------------------------------------------------------");
			System.out.println("Lista de clientes:");
			System.out.println(".");
			for(cont = 0; cont < numClientes; cont++) {
				System.out.println((cont+1) + " - " + nomeCliente[cont]);
			}
			//Seleção de cliente
			System.out.println(".");
			System.out.println("Selecione um dos clientes acima de acordo com a numeração.");
			System.out.println("Para parar de cadastrar vendas digite '0'.");
			clienteEscolhido = sc.nextInt();
			clienteEscolhido--;
			//Verificação de clientes
			if(clienteEscolhido < numClientes) {
				if(clienteEscolhido != -1) {
					do {
						//Lista de produtos
						System.out.println("----------------------------------------------------------------------");
						System.out.println("Lista de produtos:");
						System.out.println(".");
						for(cont = 0; cont < numProdutos; cont++) {
							System.out.println((cont+1) + " - " + nomeProduto[cont]);
						}
						//Seleção de produto
						System.out.println(".");
						System.out.println("Selecione um dos produtos acima de acordo com a numeração apropriada.");
						System.out.println("Para parar de cadastrar vendas para este cliente digite '0'.");
						produtoEscolhido = sc.nextInt();
						produtoEscolhido--;
						//Verificação de produtos
						if(produtoEscolhido < numProdutos) {	
							if(produtoEscolhido != -1) {
								if(quantEstoque[produtoEscolhido] > 0) {
								//Quantidade de compra
									do {
										quantValida = 0;
										System.out.println("----------------------------------------------------------------------");
										System.out.println("Digite a quantidade comprada pelo cliente:");
										quantVendida = sc.nextInt();
										//Verificação de estoque
										if(quantEstoque[produtoEscolhido] - quantVendida >= 0) {
											quantEstoque[produtoEscolhido] -= quantVendida;
											System.out.println("Compra cadastrada. Retornando à lista de produtos.");
											quantValida++;
										} else {
											System.out.println("Quantidade inválida. Não há unidades suficientes em estoque.");
											System.out.println("Tente novamente.");
										}
									} while(quantValida == 0);
								//Sem unidades no estoque
								} else if(quantEstoque[produtoEscolhido] <= 0) {
									System.out.println("...");
									System.out.println("Não há unidades do produto em estoque. Retornando à lista de produtos.");
								}
							}
						//Produto inexistente
						} else {
							System.out.println("...");
							System.out.println("Produto inexistente. Tente novamente.");
						}
					//Retorno à lista de clientes
					} while(produtoEscolhido != -1);
					System.out.println("...");
					System.out.println("Retornando à lista de clientes.");
				}
			//Cliente inexistente
			} else {
				System.out.println("...");
				System.out.println("Cliente inexistente. Tente novamente.");
			}
		} while(clienteEscolhido != -1);
		//Fim de operação
		System.out.println("...");
		System.out.println("Retornando ao menu.");
	}
	
	public static void produtosEstoque() {
		
		int cont;
		
		//Lista de produtos
		System.out.println("----------------------------------------------------------------------");
		System.out.println("Lista de produtos:");
		System.out.println(".");
		for(cont = 0; cont < numProdutos; cont++) {
			System.out.println((cont+1) + " - " + nomeProduto[cont] + " - " + quantEstoque[cont] + " em estoque.");
		}
		//Fim de operação
		System.out.println("...");
		System.out.println("Retornando ao menu.");
	}
	

}