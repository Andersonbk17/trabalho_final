   	CREATE VIEW vw_ProjetoPesquisa AS
		SELECT * FROM ProjetoPesquisa WHERE status = 1;	
	
	CREATE VIEW vw_Orientador 	AS
		SELECT * FROM Orientador WHERE status = 1;

	CREATE VIEW vw_Aluno AS
		SELECT * FROM Aluno WHERE status = 1;
			
	CREATE VIEW vw_Pessoa AS 
		SELECT * FROM Pessoa WHERE status = 1;
		
	CREATE VIEW vw_Responsavel AS
		SELECT * FROM Responsavel WHERE status = 1;

	CREATE VIEW vw_Campus AS
		SELECT * FROM Campus WHERE status = 1;

	
	
	CREATE VIEW vw_Endereco AS
		SELECT * FROM Endereco WHERE status = 1;
		
	CREATE VIEW vw_Telefone AS
		SELECT * FROM Telefone WHERE status = 1;

	CREATE VIEW vw_email AS
		SELECT * FROM Email WHERE status = 1; 
	
	CREATE VIEW vw_CursoArea AS
		SELECT * FROM CursoArea WHERE status = 1;
		
		
	CREATE VIEW vw_LocalTrabalho AS
		SELECT * FROM LocalTrabalho WHERE status = 1;

	CREATE VIEW vw_ParticipanteProjeto AS
		SELECT * FROM LocalTrabalho WHERE status = 1;
		
		
	CREATE VIEW vw_Nacionalidade AS
		SELECT idNacionalidade, nacionalidadePt as nome FROM Nacionalidade 
		
	
	CREATE VIEW vw_Cidade AS
		SELECT c.idCidade, c.nome as cidade,e.idEstado,e.nome as Estado,e.uf as uf FROM Cidade c
		INNER JOIN Estado e on e.idEstado = c.idEstado


	