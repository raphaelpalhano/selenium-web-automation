#language: pt
@Login
Funcionalidade: Gestão Ágil

#@test
  Esquema do Cenário: Validar login no sistema com usuário incorreto ​
    Dado que o gestão ágil é acessado
    Quando o login é realizado com usuário "<usuario>" e senha "<senha>"​
    Então a seguinte mensagem de erro "Credenciais incorretas!" é exibida na página de login​

	Exemplos:
		|usuario|senha|
		|asilvaga|MasterY|	
		|asilvagaa|Master| 

 #@test
  Cenário: Validar login no sistema com usuário correto​
    Dado que o gestão ágil é acessado
    Quando o login é realizado com usuário "${usuario}" e senha "${senha}"​
    Então deve exibir um titulo "Dashboard"



  @test
  Cenário: Validar login no Gestão Ágil com usuário correto
    Dado que o gestão ágil é acessado
    Quando o login é realizado com usuário "${usuario}" e senha "${senha}"​
    Então uma lista de titulos é exibida na página de inicial
    """
    Dashboard
    Gestão Ágil
    Meu Perfil
    Sair
    """
    
   @test
   Cenário: Cadastrar uma demanda com status "Backlog" com sucesso no Gestão Ágil
   	Dado que o gestão ágil é acessado
		E o login é efetuado com usuário "${usuario}" e senha "${senha}"
		E a aba "Todas as Demandas" é selecionada em Gestão Ágil
		Quando acessar página de criação de demandas
		E em nova demanda preencher o campos com os valores
		"""
		Status: BACKLOG
		Título: Demanda 
		Hora estimadas: 16,00
		Planejado - Data final: hoje+2
		"""
		* salvar nova demanda
		Então o sistema exibe a mensagem "Demanda criada com sucesso!"
   

		
		@test
	 Cenário: Verificar se não é possível cadastrar uma demanda com status "Backlog" sem o preenchimento dos campos obrigatórios no Gestão Ágil
		Dado que o gestão ágil é acessado
		E o login é efetuado com usuário "${usuario}" e senha "${senha}"
		E a aba "Todas as Demandas" é selecionada em Gestão Ágil
		Quando acessar página de criação de demandas
		E em nova demanda preencher o campos com os valores
		"""
		Status: BACKLOG
		"""
		* salvar nova demanda
		Então o sistema exibe a mensagem "Preencha o formulário adequadamente!"
		
		
	@test
   Cenário: Cadastrar uma demanda com status "Doing" com sucesso no Gestão Ágil
   	Dado que o gestão ágil é acessado
		E o login é efetuado com usuário "${usuario}" e senha "${senha}"
		E a aba "Todas as Demandas" é selecionada em Gestão Ágil
		Quando acessar página de criação de demandas
		E em nova demanda preencher o campos com os valores
		"""
		Status: DOING
		Título: Demanda
		Hora estimadas: 16,00
		Planejado - Data final: hoje+2
		Executado - Data início: hoje
		"""
		* salvar nova demanda
		Então o sistema exibe a mensagem "Demanda criada com sucesso!"
		
		
		@test
		Cenário: Verificar se não é possível cadastrar uma demanda com status "Doing" com a data de entrega executada preenchida no Gestão Ágil
			Dado que o gestão ágil é acessado
			E o login é efetuado com usuário "${usuario}" e senha "${senha}"
			E a aba "Todas as Demandas" é selecionada em Gestão Ágil
			Quando acessar página de criação de demandas
			E em nova demanda preencher o campos com os valores
				"""
				Status: DOING
				Título: Demanda
				Hora estimadas: 16,00
				Planejado - Data final: hoje+2
				"""
			* salvar nova demanda
			Então o sistema exibe a mensagem "A data de início executada deve ser informada!"
			
		@test
		Cenário: Verificar se não é possível cadastrar uma demanda com status “Doing" sem o preenchimento da data de início executada no Gestão Ágil
			Dado que o gestão ágil é acessado
			E o login é efetuado com usuário "${usuario}" e senha "${senha}"
			E a aba "Todas as Demandas" é selecionada em Gestão Ágil
			Quando acessar página de criação de demandas
			E em nova demanda preencher o campos com os valores
				"""
				Status: DOING
				Título: Demanda
				Hora estimadas: 16,00
				Planejado - Data final: hoje+2
				Executado - Data início: hoje
				Executado - Data entrega: hoje
				"""
		* salvar nova demanda
		Então o sistema exibe a mensagem "A data de entrega executada deve estar em branco em uma demanda DOING"
	
		
	
	@test
	Cenário: Verificar se a data de recebimento da demanda é habilitada até a data atual no Gestão Ágil
		Dado que o gestão ágil é acessado
		E o login é efetuado com usuário "${usuario}" e senha "${senha}"
		E a aba "Todas as Demandas" é selecionada em Gestão Ágil
		Quando acessar página de criação de demandas
		Então o campo "Data de recebimento" é habilitado até a data "atual"
			