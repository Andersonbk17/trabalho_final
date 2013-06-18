
	CREATE PROCEDURE sp_CursoArea(_nome varchar(100), _sigla varchar(20))
		BEGIN
			START TRANSACTION;
			INSERT INTO CursoArea(nome,sigla,status) VALUES(_nome,_sigla,1);
			COMMIT;
		END;
		
	CREATE PROCEDURE sp_CursoAreaAtualiza(_nome varchar(100),_sigla(20), _idCursoArea int)
		BEGIN
			START TRANSACTION;
			UPDATE SET CursoArea nome = _nome, sigla = _sigla WHERE idCursoArea = _idCursoArea;
			COMMIT;
		END;
  
	CREATE PROCEDURE sp_CursoAreaApagaTodos(_idCursoArea int)
		BEGIN
			START TRANSACTION;
			UPDATE SET CursoArea status = 0 WHERE idCursoArea = _idCursoArea;
			COMMIT;
		END;
		
	CREATE VIEW vw_CursoArea AS
		SELECT * FROM CursoArea WHERE status = 1;
  
	
	
	
	
	
	CREATE PROCEDURE sp_Email(_endereco varchar(100),_idPessoa INT)
		BEGIN
			START TRANSACTION;
			
			INSERT INTO Email(endereco,idPessoa,status) VALUES (_endereco,_idPessoa,1);
			COMMIT;
		END;
	
	CREATE PROCEDURE sp_EmailAtualiza(_endereco varchar(100), _status tinyint, _idEmail int )
		BEGIN
			START TRANSACTION;
			UPDATE SET Email endereco = _endereco, status = _status WHERE idEmail = _idEmail; 
			COMMIT;
		END;
	
	CREATE PROCEDURE sp_EmailApagaTodos(_idPessoa int)
		BEGIN 
			START TRANSACTION;
			UPDATE SET Email status = 0 WHERE idPessoa = _idPessoa;
			COMMIT;
		END;

	CREATE VIEW vw_EMAIL AS
		SELECT * FROM Email WHERE status = 1; 
	
	
	
	
	
	
	
	
	
	CREATE PROCEDURE sp_Telefone(_ddd INT , _numero INT, _idPessoa INT )
		BEGIN
			START TRANSACTION;
			INSERT INTO Telefone(ddd,numero,idPessoa,status) VALUES (_ddd,_numero,_idPessoa,1);
			COMMIT;
		END;
		
	CREATE PROCEDURE sp_TelefoneAtualiza(_ddd int, _numero int, _idTelefone int)
		BEGIN
			START TRANSACTION;
			UPDATE SET Telefone ddd = _ddd, numero = _numero WHERE idTelefone = _idTelefone;
			COMMIT;
		END;
		
	CREATE PROCEDURE sp_TelefoneApagaTodos(_idPessoa int)
		BEGIN
			START TRANSACTION;
			UPDATE SET Telefone status = 0 WHERE idPessoa = _idPessoa;
			COMMIT;
		END;
		
	CREATE VIEW vw_Telefone AS
		SELECT * FROM Telefone WHERE status = 1;
	
	
	
	
	
	
	
	
	
	CREATE PROCEDURE sp_Endereco (_rua varchar(50),_bairro varchar(50),_cep int,_numero int,_complemento varchar(50),
	_idPessoa int, _idCidade int)
		BEGIN
			START TRANSACTION;
			INSERT INTO Endereco(rua,bairro,cep,numero,complemento,idPessoa,idCidade,status) VALUES(_rua,_bairro,
			_cep,_numero,_complemento,_idPessoa,_idCidade,1);
			COMMIT;
		END;
		
	CREATE PROCEDURE sp_EnderecoAtualiza(_rua varchar(50),_bairro varchar(50),_cep int,_numero int,_complemento varchar(50),
	 _idCidade int, _idEndereco int)
		BEGIN
			START TRANSACTION;
			UPDATE SET Endereco rua = _rua, bairro = _bairro, cep = _cep, numero = _numero, complemento = _complemento, idCidade = _idCidade WHERE idEndereco = _idEndereco;
			COMMIT;
		END;
		
	CREATE PROCEDURE sp_EnderecoApagaTodos(_idPessoa int)
		BEGIN
			START TRANSACTION;
			UPDATE SET Endereco status = 0 WHERE idPessoa = _idPessoa;
			COMMIT;
		END;
		
	CREATE VIEW vw_Endereco AS
		SELECT * FROM Endereco WHERE status = 1;
		
		
		
		
		
		
		
		
		
			
	
	CREATE PROCEDURE sp_Nacionalidade (_nome varchar(20))
		BEGIN
			START TRANSACTION;
			INSERT INTO Nacionalidade(nome,status) VALUES(_nome,1);
		END;
	
	CREATE VIEW vw_Nacionalidade AS
		SELECT * FROM Nacionalidade;
	
	
	
	
	
	
	
	CREATE PROCEDURE sp_Campus(_nome varchar(100))
		BEGIN
			START TRANSACTION;
			INSERT INTO Campus(nome,status)VALUES(_nome,1);
		END;
	
	CREATE PROCEDURE sp_CampusAtualiza(_nome varchar(100),_idCampus int)
		BEGIN
			START TRANSACTION;
			UPDATE SET Campus nome = _nome WHERE idCampus = _idCampus;
			COMMIT;
		END;
	
	
	CREATE VIEW vw_Campus AS
		SELECT * FROM Campus WHERE status = 1;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	CREATE PROCEDURE sp_Responsavel(_nomeResponsavel varchar(100),_rgResponsavel varchar(20),_orgaoExpeditorResponsavel varchar(5),
	_cpfResponsavel int,_nomeMae varchar(100),_rgMae varchar(20),_orgaoExpeditorMae varchar(5),_cpfMae int)
		BEGIN
			START TRANSACTION;
			INSERT INTO Responsavel(nomeResponsavel,rgResposavel,orgaoExpeditorResponsavel,cpfResponsavel,nomeMae,rgMae,orgaoExpeditorMae,cpfMae,status) VALUES (_nomeResponsavel,
			_rgResponsavel,_orgaoExpeditorResponsavel,_cpfResponsavel,_nomeMae,_rgMae,_orgaoExpeditorMae,_cpfMae,1);
			COMMIT;
		END;
		
	CREATE PROCEDURE sp_ResponsavelAtualiza(_nomeResponsavel varchar(100),_rgResponsavel varchar(20),_orgaoExpeditorResponsavel varchar(5),
	_cpfResponsavel int,_nomeMae varchar(100),_rgMae varchar(20),_orgaoExpeditorMae varchar(5),_cpfMae int, _idResponsavel int)
		BEGIN 
			START TRANSACTION;
			UPDATE SET Responsavel nomeResponsavel = _nomeResponsavel,rgResposavel = _rgResponsavel ,orgaoExpeditorResponsavel = _orgaoExpeditorResponsavel
			,cpfResponsavel = _cpfResponsavel ,nomeMae = _nomeMae,rgMae = _rgMae,orgaoExpeditorMae = _orgaoExpeditorMae,cpfMae = _cpfMae WHERE idResponsavel = _idResponsavel;
			COMMIT;
		END;
		
	CREATE PROCEDURE sp_ResponsavelApaga(_idResponsavel int)
		BEGIN
			START TRANSACTION;
			UPDATE SET Responsavel status = 0 WHERE idResponsavel = _idResponsavel;
			COMMIT;
		END;
		
	CREATE VIEW vw_Responsavel AS
		SELECT * FROM Responsavel WHERE status = 1;
	
	
	
	
	
	
	
	
	
	CREATE PROCEDURE sp_Pessoa(_nome varchar(100), _cpf int, _rg varchar(20),_dataNascimento date,	_orgaoExpeditor varchar(5),
	_dataExpedicao date,_idCampus int,_idCursoArea int,_idNacionalidade int, _idEstado int)
		BEGIN
			START TRANSACTION;
			INSERT INTO Pessoa(nome,cpf,rg,orgaoExpeditor,dataNascimento,dataExpedicao,status,idCampus,idCursoArea,idNacionalidade,idEstado) VALUES (_nome,_cpf,_rg,_orgaoExpeditor,
			_dataNascimento,_dataExpedicao,1,_idCampus,_idCursoArea,_idNacionalidade,_idEstado);
			COMMIT;
		END;
		
		
	
	CREATE PROCEDURE sp_PessoaAtualiza(_nome varchar(100), _cpf int, _rg varchar(20),_dataNascimento date,	_orgaoExpeditor varchar(5),
	_dataExpedicao date,_idCampus int,_idCursoArea int,_idNacionalidade int, _idEstado int, _idPessoa int)
		BEGIN
			START TRANSACTION;
			UPDATE SET Pessoa nome = _nome,cpf = _cpf,rg = _rg,orgaoExpeditor = _orgaoExpeditor,dataNascimento = _dataNascimento ,dataExpedicao = _dataExpedicao,
			idCampus = _idCampus,idCursoArea  = _idCursoArea,idNacionalidade = _idNacionalidade,idEstado = _idEstado WHERE idPessoa = _idPessoa;
			COMMIT;
		END;
	
	
	
	
			
	CREATE PROCEDURE sp_Aluno(_nome varchar(100), _cpf int, _rg varchar(20),_tituloEleitoral varchar(20),_dataNascimento date,
	_orgaoExpeditor varchar(5),_dataExpedicao date,_idCampus int,_idCursoArea int,_idNacionalidade int, _idEstado int,_secaoEleitoral varchar(20),
	_zonaEleitoral varchar(20),_situacaoMilitar varchar(20),_certidaoMilitar varchar(20),_nomeResponsavel varchar(100),_rgResponsavel varchar(20),_orgaoExpeditorResponsavel varchar(5),
	_cpfResponsavel int,_nomeMae varchar(100),_rgMae varchar(20),_orgaoExpeditorMae varchar(5),_cpfMae int)
		BEGIN
			DECLARE _idPessoaAtual;
			DECLARE _idResponsavelAtual;
			START TRANSACTION;
			
			CALL sp_Pessoa(_nome , _cpf , _rg ,_dataNascimento ,_orgaoExpeditor, _dataExpedicao , _idCampus,_idCursoArea ,_idNacionalidade, _idEstado);
			
			
			CALL sp_Responsavel(_nomeResponsavel,_rgResponsavel,_orgaoExpeditorResponsavel,_cpfResponsavel,_nomeMae,_rgMae,_orgaoExpeditorMae,_cpfMae);
			
		
			_idPessoaAtual = SELECT MAX(idPessoa) FROM Pessoa;
			_idResponsavelAtual = SELECT MAX(idResponsavel) FROM Responsavel;
			
			INSERT INTO Aluno(tituloEleitor,secaoEleitoral,zonaEleitoral,situacaoMilitar,certidaoMilitar,idPessoa,idResponsavel,status) VALUES (_tituloEleitoral,_secaoEleitoral,
			_zonaEleitoral,_situacaoMilitar,_certidaoMilitar,_idPessoaAtual,_idResponsavelAtual,1);
			
			COMMIT;
		END;
		
	
	CREATE PROCEDURE sp_AlunoAtualiza(_nome varchar(100), _cpf int, _rg varchar(20),_tituloEleitoral varchar(20),_dataNascimento date,
	_orgaoExpeditor varchar(5),_dataExpedicao date,_idCampus int,_idCursoArea int,_idNacionalidade int, _idEstado int,_secaoEleitoral varchar(20),
	_zonaEleitoral varchar(20),_situacaoMilitar varchar(20),_certidaoMilitar varchar(20),_nomeResponsavel varchar(100),_rgResponsavel varchar(20),_orgaoExpeditorResponsavel varchar(5),
	_cpfResponsavel int,_nomeMae varchar(100),_rgMae varchar(20),_orgaoExpeditorMae varchar(5),_cpfMae int,_idAluno int, _idPessoa int)
		BEGIN
			START TRANSACTION;
			
			
			CALL sp_PessoaAtualiza(_nome , _cpf , _rg ,_tituloEleitoral ,_dataNascimento , _orgaoExpeditor ,	_dataExpedicao ,_idCampus ,_idCursoArea,_idNacionalidade ,
			_idEstado , _idPessoa );
			
		
			UPDATE SET Aluno tituloEleitor = _tituloEleitoral,secaoEleitoral _secaoEleitoral ,zonaEleitoral = _zonaEleitoral ,situacaoMilitar = _situacaoMilitar,
			certidaoMilitar = _certidaoMilitar WHERE idAluno = _idAluno;
			
			COMMIT;
		END;
		
	CREATE PROCEDURE sp_AlunoApaga(_idPessoa int)
		BEGIN
			START TRANSACTION;
			CALL sp_EmailApagaTodos(_idPessoa);
			CALL sp_EnderecoApagaTodos(_idPessoa);
			CALL sp_TelefoneApagaTodos(_idPessoa);
			
			UPDATE SET Aluno status = 0 WHERE idPessoa =_idPessoa;
			UPDATE SET Pessoa status = 0 WHERE idPessoa = _idPessoa;
			
			COMMIT;
		END;
	

	
	
	
	
	
	
	
	
	CREATE PROCEDURE sp_Orientador(_nome varchar(100), _cpf int, _rg varchar(20),_dataNascimento date,_orgaoExpeditor varchar(5),_dataExpedicao date,
	_idCampus int,_idCursoArea int,_idNacionalidade int, _idEstado int,_matriculaSiape int,_localPermanencia varchar(100),_formacaoUniversitaria varchar(100),
	_tituloAcademico varchar(100))
		BEGIN
			DECLARE _idPessoaAtual;
			START TRANSACTION;
			
			CALL sp_Pessoa(_nome , _cpf , _rg ,_tituloEleitoral ,_dataNascimento ,	_orgaoExpeditor, _dataExpedicao , _idCampus,_idCursoArea ,_idNacionalidade, _idEstado);
			
			_idPessoaAtual = SELECT MAX(idPessoa) FROM Pessoa;
			
			INSERT INTO Orientador(matriculaSiape,localPermanencia,formacaoUniversitaria,tituloAcademico,idPessoa,status) VALUES (_matriculaSiape,_localPermanencia,formacaoUniversitaria,
			_tituloAcademico,_idPessoaAtual,1);
			
		END;
		
		
		
	CREATE PROCEDURE sp_OrientadorAtualiza(_nome varchar(100), _cpf int, _rg varchar(20),_dataNascimento date,_orgaoExpeditor varchar(5),_dataExpedicao date,_idCampus int,
	_idCursoArea int,_idNacionalidade int, _idEstado int,_matriculaSiape int,_localPermanencia varchar(100),_formacaoUniversitaria varchar(100), _tituloAcademico varchar(100),
	_idPessoa int,_idOrientador int)
		BEGIN
			START TRANSACTION;
			
			
			CALL sp_PessoaAtualiza(_nome , _cpf, _rg ,_tituloEleitoral ,_dataNascimento ,_orgaoExpeditor,_dataExpedicao ,_idCampus ,_idCursoArea ,
			_idNacionalidade , _idEstado , _idPessoa);
			
			UPDATE SET Orientador matriculaSiape = _matriculaSiape,localPermanencia = _localPermanencia ,formacaoUniversitaria = _formacaoUniversitaria ,
			tituloAcademico = _tituloAcademico WHERE idOrientador = _idOrientador;
			
		
		
		
		
	
	CREATE PROCEDURE sp_ProjetoPesquisa(_titulo varchar(100),_dataInicio date,_dataTermino date,_grupoPesquisa varchar(100),_idAreaConhecimentoCNPq int,_idCampus int,_resumo text,
	_idOrientador int,_financiamento tinyint,_bolsa tinyint, _convenio tinyint,_valorFinanciamento float,_dataFinanciamento date,_numeroBolsas int,_agenciaFinanciadora varchar(100),
	_convenio tinyint,_nomeConvenio varchar(100),_projetoMulticampi tinyint,status) 
		BEGIN
			START TRANSACTION;
			
			INSERT INTO ProjetoPesquisa(titulo,dataInicio,dataTermino,grupoPesquisa,idAreaConhecimentoCNPq,idCampus,resumo,idOrientador,financiamento,bolsa,convenio,valorFinanciamento,
			dataFinanciamento,numeroBolsas,agenciaFinanciadora,convenio,nomeConvenio,projetoMulticampi,status) VALUES (
			
	
	
	VALUES (