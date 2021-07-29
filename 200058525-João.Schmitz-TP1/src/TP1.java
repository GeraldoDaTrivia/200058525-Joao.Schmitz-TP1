import java.util.Scanner;

public class TP1 {
	
//Vari�veis
	static int op�aoMenu, numClientes=0, numProdutos=0;
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
	
//M�todos
	public static void main(String[] args) {
		
	//Dados pr�-carregados (Clientes)
		for(int cont = 0; cont < 10; cont++) {
			nomeCliente[numClientes] = "Cliente "+numClientes;
			endCliente[numClientes] = "Rua "+numClientes;
			telCliente[numClientes] = "9813000"+numClientes;
			
			numClientes++;
		}

	//Dados pr�-carregados (Produtos)
		for(int cont = 0; cont < 10; cont++) {
			nomeProduto[numProdutos] = "Produto "+numProdutos;
			descProduto[numProdutos] = "Descri��o "+numProdutos;
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
			
			//Receber op��o
			System.out.println("Qual op��o deseja realizar ?");
			op�aoMenu = sc.nextInt();
			
			//Opera��es
			switch(op�aoMenu) {
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
					System.out.println("Op��o inv�lida. Por favor escolher op��o v�lida.");
					break;
			}
		} while(op�aoMenu != 7);
		
	}
	
	public static void cadastroCliente() {
		
		int quantCadastros, cont;

		//Quantidade de cadastros
		System.out.println("----------------------------------------------------------------------");
		System.out.println("Quantos clientes ser�o cadastrados ?");
		quantCadastros = sc.nextInt();
		if(quantCadastros > 0) {
			//Cadastro de dados
			System.out.println("Informe os dados dos clientes para o cadastro.");
			sc.nextLine();
			for(cont = 0; cont < quantCadastros; cont++) {
				System.out.println("----------------------------------------------------------------------");
				System.out.println("Nome do cliente:");
				nomeCliente[numClientes] = sc.nextLine();
				System.out.println("Endere�o do cliente:");
				endCliente[numClientes] = sc.nextLine();
				System.out.println("Telefone do cliente:");
				telCliente[numClientes] = sc.nextLine();
				
				numClientes++;
			}
		} else {
			System.out.println("Quantidade inv�lida.");
		}
		//Fim de opera��o
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
			
			//Verifica��o de clientes
			for(cont = 0; cont < numClientes; cont++) {
				if(nomeBusca.equals(nomeCliente[cont])) {
					//Mostrar os dados obtidos
					System.out.println("Nome: " + nomeCliente[cont]);
					System.out.println("Endere�o: " + endCliente[cont]);
					System.out.println("Telefone: " + telCliente[cont]);
					
					do {
						//Escolher se ir� mudar os dados
						System.out.println("----------------------------------------------------------------------");
						System.out.println("Deseja realizar mudan�as nos dados deste cliente ?");
						System.out.println("1. Sim.");
						System.out.println("2. N�o.");
						mudarDados = sc.nextInt();
						switch(mudarDados) {
							//Alterar dados
							case 1:
								do {
									System.out.println("----------------------------------------------------------------------");
									System.out.println("Qual dado deseja alterar ?");
									System.out.println("1. Nome.");
									System.out.println("2. Endere�o.");
									System.out.println("3. Telefone.");
									System.out.println("4. Terminar altera��es.");
									escolhaAlt = sc.nextInt();
									sc.nextLine();
									switch(escolhaAlt) {
										//Altera��o de nome
										case 1:
											System.out.println("----------------------------------------------------------------------");
											System.out.println("Digite o novo nome:");
											nomeCliente[cont] = sc.nextLine();
											break;
										//Altera��o de endere�o
										case 2:
											System.out.println("----------------------------------------------------------------------");
											System.out.println("Digite o novo endere�o:");
											endCliente[cont] = sc.nextLine();
											break;
										//Altera��o de telefone
										case 3:
											System.out.println("----------------------------------------------------------------------");
											System.out.println("Digite o novo telefone:");
											telCliente[cont] = sc.nextLine();
											break;
										//Fim das altera��es
										case 4:
											System.out.println("----------------------------------------------------------------------");
											System.out.println("Dados salvos.");
											mudarDados = 2;
											break;
										//Op��o inv�lida
										default:
											System.out.println("----------------------------------------------------------------------");
											System.out.println("Op��o inv�lida. Por favor escolher op��o v�lida.");
											break;
									}
								} while(escolhaAlt != 4);
								break;
							//N�o alterar dados
							case 2:
								System.out.println("----------------------------------------------------------------------");
								System.out.println("Dados salvos.");
								break;
							//Op��o inv�lida
							default:
								System.out.println("----------------------------------------------------------------------");
								System.out.println("Op��o inv�lida. Por favor escolher op��o v�lida.");
								break;
						}
					} while(mudarDados != 2);
					
					nomesIguais++;
				}
			}
			//Caso n�o tiver nomes correspondentes
			if(nomesIguais==0) {
				System.out.println("Cliente n�o encontrado!");
			}
			//Repetir a busca
			System.out.println("----------------------------------------------------------------------");
			System.out.println("Deseja realizar outra busca ?");
			System.out.println("1. Sim.");
			System.out.println("2. Voltar ao menu.");
			novaBusca = sc.nextInt();
		} while(novaBusca == 1);
		//Fim de opera��o
		System.out.println("...");
		System.out.println("Retornando ao menu.");
	}
	
	public static void cadastroProduto() {
		
		int quantCadastros, cont;

		//Quantidade de cadastros
		System.out.println("Quantos produtos ser�o cadastrados ?");
		quantCadastros = sc.nextInt();
		if(quantCadastros > 0) {
			//Cadastro de dados
			System.out.println("Informe os dados dos produtos para o cadastro.");
			for(cont = 0; cont < quantCadastros; cont++) {
				sc.nextLine();
				System.out.println("----------------------------------------------------------------------");
				System.out.println("Nome do produto:");
				nomeProduto[numProdutos] = sc.nextLine();
				System.out.println("Descri��o do produto:");
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
			System.out.println("Quantidade inv�lida.");
		}
		//Fim de opera��o
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
			
			//Verifica��o de produtos
			for(cont = 0; cont < numProdutos; cont++) {
				if(nomeBusca.equals(nomeProduto[cont])) {
					//Mostrar os dados obtidos
					System.out.println("Nome: " + nomeProduto[cont]);
					System.out.println("Descri��o: " + descProduto[cont]);
					System.out.printf("Valor de compra: R$%.2f\n", valorProduto[cont]);
					System.out.println("Porc. de lucro: " + porcLucro[cont] + "%");
					System.out.println("Quant. em estoque: " + quantEstoque[cont]);
					
					do {
						//Escolher se ir� mudar os dados
						System.out.println("----------------------------------------------------------------------");
						System.out.println("Deseja realizar mudan�as nos dados deste produto ?");
						System.out.println("1. Sim.");
						System.out.println("2. N�o.");
						mudarDados = sc.nextInt();
						switch(mudarDados) {
							//Alterar dados
							case 1:
								do {
									System.out.println("----------------------------------------------------------------------");
									System.out.println("Qual dado deseja alterar ?");
									System.out.println("1. Nome.");
									System.out.println("2. Descri��o.");
									System.out.println("3. Valor de compra.");
									System.out.println("4. Porcentagem de lucro.");
									System.out.println("5. Quantidade em estoque.");
									System.out.println("6. Terminar altera��es.");
									escolhaAlt = sc.nextInt();
									sc.nextLine();
									switch(escolhaAlt) {
										//Altera��o de nome
										case 1:
											System.out.println("----------------------------------------------------------------------");
											System.out.println("Digite o novo nome:");
											nomeProduto[cont] = sc.nextLine();
											break;
										//Altera��o de descri��o
										case 2:
											System.out.println("----------------------------------------------------------------------");
											System.out.println("Digite a nova descri��o:");
											descProduto[cont] = sc.nextLine();
											break;
										//Altera��o de valor de compra
										case 3:
											System.out.println("----------------------------------------------------------------------");
											System.out.println("Digite o novo valor de compra:");
											valorProduto[cont] = sc.nextDouble();
											break;
										//Altera��o de porcentagem de lucro
										case 4:
											System.out.println("----------------------------------------------------------------------");
											System.out.println("Digite a nova porcentagem de lucro:");
											porcLucro[cont] = sc.nextDouble();
											break;
										//Altera��o de quantidade em estoque
										case 5:
											System.out.println("----------------------------------------------------------------------");
											System.out.println("Digite a nova quantidade no estoque:");
											quantEstoque[cont] = sc.nextInt();
											break;
										//Fim das altera��es
										case 6:
											System.out.println("----------------------------------------------------------------------");
											System.out.println("Dados salvos.");
											mudarDados = 2;
											break;
										//Op��o inv�lida
										default:
											System.out.println("----------------------------------------------------------------------");
											System.out.println("Op��o inv�lida. Por favor escolher op��o v�lida.");
											break;
									}
								} while(escolhaAlt != 6);
								break;
							//N�o alterar dados
							case 2:
								System.out.println("----------------------------------------------------------------------");
								System.out.println("Dados salvos.");
								break;
							//Op��o inv�lida
							default:
								System.out.println("----------------------------------------------------------------------");
								System.out.println("Op��o inv�lida. Por favor escolher op��o v�lida.");
								break;
						}
					} while(mudarDados != 2);
					
					nomesIguais++;
				}
			}
			//Caso n�o tiver nomes correspondentes
			if(nomesIguais==0) {
				System.out.println("Produto n�o encontrado!");
			}
			//Repetir a busca
			System.out.println("----------------------------------------------------------------------");
			System.out.println("Deseja realizar outra busca ?");
			System.out.println("1. Sim.");
			System.out.println("2. Voltar ao menu.");
			novaBusca = sc.nextInt();
		} while(novaBusca == 1);
		//Fim de opera��o
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
			//Sele��o de cliente
			System.out.println(".");
			System.out.println("Selecione um dos clientes acima de acordo com a numera��o.");
			System.out.println("Para parar de cadastrar vendas digite '0'.");
			clienteEscolhido = sc.nextInt();
			clienteEscolhido--;
			//Verifica��o de clientes
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
						//Sele��o de produto
						System.out.println(".");
						System.out.println("Selecione um dos produtos acima de acordo com a numera��o apropriada.");
						System.out.println("Para parar de cadastrar vendas para este cliente digite '0'.");
						produtoEscolhido = sc.nextInt();
						produtoEscolhido--;
						//Verifica��o de produtos
						if(produtoEscolhido < numProdutos) {	
							if(produtoEscolhido != -1) {
								if(quantEstoque[produtoEscolhido] > 0) {
								//Quantidade de compra
									do {
										quantValida = 0;
										System.out.println("----------------------------------------------------------------------");
										System.out.println("Digite a quantidade comprada pelo cliente:");
										quantVendida = sc.nextInt();
										//Verifica��o de estoque
										if(quantEstoque[produtoEscolhido] - quantVendida >= 0) {
											quantEstoque[produtoEscolhido] -= quantVendida;
											System.out.println("Compra cadastrada. Retornando � lista de produtos.");
											quantValida++;
										} else {
											System.out.println("Quantidade inv�lida. N�o h� unidades suficientes em estoque.");
											System.out.println("Tente novamente.");
										}
									} while(quantValida == 0);
								//Sem unidades no estoque
								} else if(quantEstoque[produtoEscolhido] <= 0) {
									System.out.println("...");
									System.out.println("N�o h� unidades do produto em estoque. Retornando � lista de produtos.");
								}
							}
						//Produto inexistente
						} else {
							System.out.println("...");
							System.out.println("Produto inexistente. Tente novamente.");
						}
					//Retorno � lista de clientes
					} while(produtoEscolhido != -1);
					System.out.println("...");
					System.out.println("Retornando � lista de clientes.");
				}
			//Cliente inexistente
			} else {
				System.out.println("...");
				System.out.println("Cliente inexistente. Tente novamente.");
			}
		} while(clienteEscolhido != -1);
		//Fim de opera��o
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
		//Fim de opera��o
		System.out.println("...");
		System.out.println("Retornando ao menu.");
	}
	

}