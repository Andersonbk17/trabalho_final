DELIMITER //
	CREATE PROCEDURE sp_CursoArea(_nome varchar(100), _sigla varchar(20))
		BEGIN
			DECLARE exit HANDLER FOR SQLEXCEPTION ROLLBACK; 
			START TRANSACTION;
			INSERT INTO CursoArea (nome,sigla,status) VALUES(_nome,_sigla,1);
			COMMIT;
		END;
//
DELIMITER //	
	CREATE PROCEDURE sp_CursoAreaAtualiza(_nome varchar(100),_sigla varchar(20), _idCursoArea int)
		BEGIN
			DECLARE exit HANDLER FOR SQLEXCEPTION ROLLBACK;
			START TRANSACTION;
			UPDATE CursoArea SET  nome = _nome, sigla = _sigla WHERE idCursoArea = _idCursoArea;
			COMMIT;	
		END;
//
DELIMITER //
	CREATE PROCEDURE sp_CursoAreaApaga(_idCursoArea int)
		BEGIN
			DECLARE exit HANDLER FOR SQLEXCEPTION ROLLBACK;
			START TRANSACTION;
			UPDATE CursoArea SET status = 0 WHERE idCursoArea = _idCursoArea;
			COMMIT;
		END;
//
DELIMITER //

	CREATE PROCEDURE sp_Email(_endereco varchar(100),_idPessoa INT)
		BEGIN
			DECLARE exit HANDLER FOR SQLEXCEPTION ROLLBACK;
			START TRANSACTION;
			INSERT INTO Email(endereco,idPessoa,status) VALUES (_endereco,_idPessoa,1);
			COMMIT;	
		END;
//
DELIMITER //	
	CREATE PROCEDURE sp_EmailAtualiza(_endereco varchar(100), _status tinyint, _idEmail int )
		BEGIN
			DECLARE exit HANDLER FOR SQLEXCEPTION ROLLBACK;
			START TRANSACTION;
			UPDATE Email SET  endereco = _endereco, status = _status WHERE idEmail = _idEmail; 			
			COMMIT;
		END;
//
DELIMITER //	
	CREATE PROCEDURE sp_EmailApaga(_idPessoa int)
		BEGIN 
			DECLARE exit HANDLER FOR SQLEXCEPTION ROLLBACK;
			START TRANSACTION;
			UPDATE Email SET  status = 0 WHERE idPessoa = _idPessoa;
			COMMIT;
		END;
//
DELIMITER //
	
	CREATE PROCEDURE sp_Telefone(_ddd INT , _numero INT, _idPessoa INT )
		BEGIN
			DECLARE exit HANDLER FOR SQLEXCEPTION ROLLBACK;
			START TRANSACTION;
			INSERT INTO Telefone(ddd,numero,idPessoa,status) VALUES (_ddd,_numero,_idPessoa,1);
			COMMIT;
		END;
//
DELIMITER //	
	CREATE PROCEDURE sp_TelefoneAtualiza(_ddd int, _numero int, _idTelefone int)
		BEGIN
			DECLARE exit HANDLER FOR SQLEXCEPTION ROLLBACK;
			START TRANSACTION;
			UPDATE  Telefone SET ddd = _ddd, numero = _numero WHERE idTelefone = _idTelefone;
			COMMIT;
		END;
//
DELIMITER //	
	CREATE PROCEDURE sp_TelefoneApaga(_idPessoa int)
		BEGIN
			DECLARE exit HANDLER FOR SQLEXCEPTION ROLLBACK;
			START TRANSACTION;
			UPDATE SET Telefone status = 0 WHERE idPessoa = _idPessoa;
			COMMIT;
		END;
//
DELIMITER //
	CREATE PROCEDURE sp_Endereco (_rua varchar(50),_bairro varchar(50),_cep int,_numero int,_complemento varchar(50),_idPessoa int,
	_idCidade int)
		BEGIN
			DECLARE exit HANDLER FOR SQLEXCEPTION ROLLBACK;
			START TRANSACTION;	
			INSERT INTO Endereco(rua,bairro,cep,numero,complemento,idPessoa,idCidade,status) VALUES(_rua,_bairro,
			_cep,_numero,_complemento,_idPessoa,_idCidade,1);
			COMMIT;	
		END;
//
DELIMITER //	
	CREATE PROCEDURE sp_EnderecoAtualiza(_rua varchar(50),_bairro varchar(50),_cep int,_numero int,_complemento varchar(50),_idCidade int, _idEndereco int)
		BEGIN
			DECLARE exit HANDLER FOR SQLEXCEPTION ROLLBACK;
			START TRANSACTION;
			UPDATE Endereco SET rua = _rua, bairro = _bairro, cep = _cep, numero = _numero, complemento = _complemento, idCidade = _idCidade 
			WHERE idEndereco = _idEndereco;
			COMMIT;	
		END;
//
DELIMITER //	
	CREATE PROCEDURE sp_EnderecoApagar(_idPessoa int)
		BEGIN
			DECLARE exit HANDLER FOR SQLEXCEPTION ROLLBACK;
			START TRANSACTION;
			UPDATE Endereco SET  status = 0 
			WHERE idPessoa = _idPessoa;
			COMMIT;
		END;
//
DELIMITER //				
		CREATE PROCEDURE sp_Nacionalidade(_nome varchar(20))
		BEGIN
			DECLARE exit HANDLER FOR SQLEXCEPTION ROLLBACK;
			START TRANSACTION;
			INSERT INTO Nacionalidade(nome,status) 
			VALUES(_nome,1);
			COMMIT;
		END;
//
DELIMITER //		
	CREATE PROCEDURE sp_NacionalidadeAtualiza(_nome varchar(20), _idEmail int)
		BEGIN
			DECLARE exit HANDLER FOR SQLEXCEPTION ROLLBACK;
			START TRANSACTION;
			UPDATE Nacionalidade SET nome = _nome 
			WHERE idNascionalidade = _idNascionalidade;
			COMMIT;
		END;
//
DELIMITER //	
	CREATE PROCEDURE sp_NacionalidadeApaga(_idNascionalidade int)
		BEGIN
			DECLARE exit HANDLER FOR SQLEXCEPTION ROLLBACK;
			START TRANSACTION;
			UPDATE Nacionalidade SET status = 0 
			WHERE idNascionalidade = _idNascionalidade;
			COMMIT;
		END;
//
DELIMITER //			
	CREATE PROCEDURE sp_Campus(_nome varchar(100))
		BEGIN
			DECLARE exit HANDLER FOR SQLEXCEPTION ROLLBACK;
			START TRANSACTION;
			INSERT INTO Campus(nome,status)
			VALUES(_nome,1);
			COMMIT;
		END;
//
DELIMITER //	
	CREATE PROCEDURE sp_CampusAtualiza(_nome varchar(100),_idCampus int)
		BEGIN
			DECLARE exit HANDLER FOR SQLEXCEPTION ROLLBACK;
			START TRANSACTION;
			UPDATE Campus SET nome = _nome 
			WHERE idCampus = _idCampus;
			COMMIT;
		END;
//
DELIMITER //	
	CREATE PROCEDURE sp_CampusApaga(_idCampus int)
		BEGIN
			DECLARE exit HANDLER FOR SQLEXCEPTION ROLLBACK;
			START TRANSACTION;
			UPDATE Campus SET status = 0
			WHERE idCampus = _idCampus;
			COMMIT;
		END;
//
DELIMITER //

	CREATE PROCEDURE sp_Responsavel(_nomeResponsavel varchar(100),_rgResponsavel varchar(20),_orgaoExpeditorResponsavel varchar(5),_cpfResponsavel int,
	_nomeMae varchar(100),_rgMae varchar(20),_orgaoExpeditorMae varchar(5),_cpfMae int)
		BEGIN
			DECLARE exit HANDLER FOR SQLEXCEPTION ROLLBACK;
			START TRANSACTION;
			INSERT INTO Responsavel(nomeResponsavel,rgResposavel,orgaoExpeditorResponsavel,cpfResponsavel,nomeMae,rgMae,orgaoExpeditorMae,cpfMae,status) 
			VALUES (_nomeResponsavel,_rgResponsavel,_orgaoExpeditorResponsavel,_cpfResponsavel,_nomeMae,_rgMae,_orgaoExpeditorMae,_cpfMae,1);
			COMMIT;
		END;
//
DELIMITER //	
	CREATE PROCEDURE sp_ResponsavelAtualiza(_nomeResponsavel varchar(100),_rgResponsavel varchar(20),_orgaoExpeditorResponsavel varchar(5),
	_cpfResponsavel int,_nomeMae varchar(100),_rgMae varchar(20),_orgaoExpeditorMae varchar(5),_cpfMae int, _idResponsavel int)
		BEGIN 
			DECLARE exit HANDLER FOR SQLEXCEPTION ROLLBACK;
			START TRANSACTION;
			UPDATE Responsavel SET nomeResponsavel = _nomeResponsavel,rgResposavel = _rgResponsavel ,orgaoExpeditorResponsavel = _orgaoExpeditorResponsavel,
			cpfResponsavel = _cpfResponsavel ,nomeMae = _nomeMae,rgMae = _rgMae,orgaoExpeditorMae = _orgaoExpeditorMae,cpfMae = _cpfMae 
			WHERE idResponsavel = _idResponsavel;
			COMMIT;
		END;
//
DELIMITER //		
	CREATE PROCEDURE sp_ResponsavelApaga(_idResponsavel int)
		BEGIN
			DECLARE exit HANDLER FOR SQLEXCEPTION ROLLBACK;
			START TRANSACTION;
			UPDATE Responsavel SET status = 0 
			WHERE idResponsavel = _idResponsavel;
			COMMIT;
		END;
//
DELIMITER //

	CREATE PROCEDURE sp_Pessoa(_nome varchar(100), _cpf int, _rg varchar(20),_dataNascimento date,	_orgaoExpeditor varchar(5),
	_dataExpedicao date,_idCampus int,_idCursoArea int,_idNacionalidade int, _idEstado int)
		BEGIN
			DECLARE exit HANDLER FOR SQLEXCEPTION ROLLBACK;
			START TRANSACTION;
			INSERT INTO Pessoa(nome,cpf,rg,orgaoExpeditor,dataNascimento,dataExpedicao,status,idCampus,idCursoArea,idNacionalidade,idEstado) 
			VALUES (_nome,_cpf,_rg,_orgaoExpeditor,_dataNascimento,_dataExpedicao,1,_idCampus,_idCursoArea,_idNacionalidade,_idEstado);
			COMMIT;
		END;
//
DELIMITER //		
	CREATE PROCEDURE sp_PessoaAtualiza(_nome varchar(100), _cpf int, _rg varchar(20),_dataNascimento date,	_orgaoExpeditor varchar(5),
	_dataExpedicao date,_idCampus int,_idCursoArea int,_idNacionalidade int, _idEstado int, _idPessoa int)
		BEGIN
			DECLARE exit HANDLER FOR SQLEXCEPTION ROLLBACK;
			START TRANSACTION;
			UPDATE Pessoa SET  nome = _nome,cpf = _cpf,rg = _rg,orgaoExpeditor = _orgaoExpeditor,dataNascimento = _dataNascimento ,dataExpedicao = _dataExpedicao,
			idCampus = _idCampus,idCursoArea  = _idCursoArea,idNacionalidade = _idNacionalidade,idEstado = _idEstado 
			WHERE idPessoa = _idPessoa;
			COMMIT;
		END;
//
DELIMITER //
	CREATE PROCEDURE sp_PessoaApaga(_idPessoa int)
		BEGIN
			DECLARE exit HANDLER FOR SQLEXCEPTION ROLLBACK;
			START TRANSACTION;
			UPDATE Pessoa SET  status = 0 WHERE idPessoa = _idPessoa;
			COMMIT;
		END;
//
DELIMITER //	
	CREATE PROCEDURE sp_Aluno(_nome varchar(100), _cpf int, _rg varchar(20),_tituloEleitoral varchar(20),_dataNascimento date,_orgaoExpeditor varchar(5),
	_dataExpedicao date,_idCampus int,_idCursoArea int,_idNacionalidade int, _idEstado int,_secaoEleitoral varchar(20),_zonaEleitoral varchar(20),
	_situacaoMilitar varchar(20),_certidaoMilitar varchar(20),_nomeResponsavel varchar(100),_rgResponsavel varchar(20),_orgaoExpeditorResponsavel varchar(5),
	_cpfResponsavel int,_nomeMae varchar(100),_rgMae varchar(20),_orgaoExpeditorMae varchar(5),_cpfMae int,_matricula int)
		BEGIN
			DECLARE _idPessoaAtual int;
			DECLARE _idResponsavelAtual int;
			DECLARE exit HANDLER FOR SQLEXCEPTION ROLLBACK;
			START TRANSACTION;
			
			CALL sp_Pessoa(_nome , _cpf , _rg ,_dataNascimento ,_orgaoExpeditor, _dataExpedicao , _idCampus,_idCursoArea ,_idNacionalidade, _idEstado);
			CALL sp_Responsavel(_nomeResponsavel,_rgResponsavel,_orgaoExpeditorResponsavel,_cpfResponsavel,_nomeMae,_rgMae,_orgaoExpeditorMae,_cpfMae);
			
			SET _idPessoaAtual = (SELECT MAX(idPessoa) FROM Pessoa);
			SET _idResponsavelAtual = (SELECT MAX(idResponsavel) FROM Responsavel);
			
			INSERT INTO Aluno(tituloEleitor,secaoEleitoral,zonaEleitoral,situacaoMilitar,certidaoMilitar,idPessoa,idResponsavel,status,matricula) 
			VALUES (_tituloEleitoral,_secaoEleitoral,_zonaEleitoral,_situacaoMilitar,_certidaoMilitar,_idPessoaAtual,_idResponsavelAtual,1,_matricula);
			COMMIT;
		END;
//
DELIMITER //	
	CREATE PROCEDURE sp_AlunoAtualiza(_nome varchar(100), _cpf int, _rg varchar(20),_tituloEleitoral varchar(20),_dataNascimento date,
	_orgaoExpeditor varchar(5),_dataExpedicao date,_idCampus int,_idCursoArea int,_idNacionalidade int, _idEstado int,_secaoEleitoral varchar(20),
	_zonaEleitoral varchar(20),_situacaoMilitar varchar(20),_certidaoMilitar varchar(20),_nomeResponsavel varchar(100),_rgResponsavel varchar(20),
	_orgaoExpeditorResponsavel varchar(5),_cpfResponsavel int,_nomeMae varchar(100),_rgMae varchar(20),_orgaoExpeditorMae varchar(5),_cpfMae int,
	_idAluno int, _idPessoa int,_matricula int)
		BEGIN
			DECLARE exit HANDLER FOR SQLEXCEPTION ROLLBACK;
			START TRANSACTION;
			
			CALL sp_PessoaAtualiza(_nome,_cpf,_rg,_tituloEleitoral,_dataNascimento,_orgaoExpeditor,_dataExpedicao,_idCampus,_idCursoArea,_idNacionalidade,
			_idEstado,_idPessoa );
			
			UPDATE Aluno SET  tituloEleitor = _tituloEleitoral,secaoEleitoral = _secaoEleitoral ,zonaEleitoral = _zonaEleitoral ,situacaoMilitar = _situacaoMilitar,
			certidaoMilitar = _certidaoMilitar, matricula = _matricula
			WHERE idAluno = _idAluno;
			COMMIT;
		END;
//
DELIMITER //
	CREATE PROCEDURE sp_AlunoApaga(_idPessoa int,_idAluno)
		BEGIN
			DECLARE exit HANDLER FOR SQLEXCEPTION ROLLBACK;
			START TRANSACTION;
			
			CALL sp_EmailApaga(_idPessoa);
			CALL sp_EnderecoApaga(_idPessoa);
			CALL sp_TelefoneApaga(_idPessoa);
			
			UPDATE Aluno SET  status = 0 WHERE idAluno =_idAluno;
			UPDATE Pessoa SET  status = 0 WHERE idPessoa = _idPessoa;
			
			COMMIT;
		END;
//
DELIMITER //
	CREATE PROCEDURE sp_Orientador(_nome varchar(100), _cpf int, _rg varchar(20),_dataNascimento date,_orgaoExpeditor varchar(5),
	_dataExpedicao date,_idCampus int,_idCursoArea int,_idNacionalidade int, _idEstado int,_matriculaSiape int,
	_localPermanencia varchar(100),_formacaoUniversitaria varchar(100),	_tituloAcademico varchar(100))
		BEGIN
			DECLARE _idPessoaAtual int;
			DECLARE exit HANDLER FOR SQLEXCEPTION ROLLBACK;
			START TRANSACTION;
			
			CALL sp_Pessoa(_nome,_cpf,_rg,_tituloEleitoral,_dataNascimento,_orgaoExpeditor,_dataExpedicao,_idCampus,_idCursoArea,_idNacionalidade,_idEstado);
			
			SET _idPessoaAtual = (SELECT MAX(idPessoa) FROM Pessoa);
			
			INSERT INTO Orientador(matriculaSiape,localPermanencia,formacaoUniversitaria,tituloAcademico,idPessoa,status) 
			VALUES (_matriculaSiape,_localPermanencia,_formacaoUniversitaria,_tituloAcademico,_idPessoaAtual,1);
			COMMIT;
		END;
//
DELIMITER //		
	CREATE PROCEDURE sp_OrientadorAtualiza(_nome varchar(100),_cpf int,_rg varchar(20),_dataNascimento date,_orgaoExpeditor varchar(5),_dataExpedicao date,
	_idCampus int,_idCursoArea int,_idNacionalidade int,_idEstado int,_matriculaSiape int,_localPermanencia varchar(100),_formacaoUniversitaria varchar(100), 
	_tituloAcademico varchar(100),_idPessoa int,_idOrientador int)
		BEGIN
			DECLARE exit HANDLER FOR SQLEXCEPTION ROLLBACK;
			START TRANSACTION;
			
			CALL sp_PessoaAtualiza(_nome,_cpf,_rg,_tituloEleitoral,_dataNascimento,_orgaoExpeditor,_dataExpedicao,_idCampus,_idCursoArea,
			_idNacionalidade,_idEstado,_idPessoa);		
			
			UPDATE Orientador SET  matriculaSiape = _matriculaSiape,localPermanencia = _localPermanencia ,formacaoUniversitaria = _formacaoUniversitaria,
			tituloAcademico = _tituloAcademico 
			WHERE idOrientador = _idOrientador;
			COMMIT;
		END;
//


DELIMITER //
	CREATE PROCEDURE sp_OrientadorApaga(_idPessoa int,_idOrientador int)
		BEGIN
			DECLARE exit HANDLER FOR SQLEXCEPTION ROLLBACK;
			START TRANSACTION;
			
			CALL sp_EmailApaga(_idPessoa);
			CALL sp_EnderecoApaga(_idPessoa);
			CALL sp_TelefoneApaga(_idPessoa);
			
			UPDATE Pessoa SET  status = 0 WHERE idPessoa =_idPessoa;
			UPDATE Orientador SET  status = 0 WHERE idOrientador = _idOrientador;
			
			COMMIT;
		END;
//




DELIMITER //			
	CREATE PROCEDURE sp_ProjetoPesquisa(_titulo varchar(100),_dataInicio date,_dataTermino date,_grupoPesquisa varchar(100),_idAreaConhecimentoCNPq int,_idCampus int,
	_resumo text,_idOrientador int,_financiamento tinyint,_bolsa tinyint, _convenio tinyint,_valorFinanciamento float,_dataFinanciamento date,_numeroBolsas int,
	_agenciaFinanciadora varchar(100),_nomeConvenio varchar(100),_projetoMulticampi tinyint) 
		BEGIN
			DECLARE exit HANDLER FOR SQLEXCEPTION ROLLBACK;
			START TRANSACTION;
			INSERT INTO ProjetoPesquisa(titulo,dataInicio,dataTermino,grupoPesquisa,idAreaConhecimentoCNPq,idCampus,resumo,idOrientador,financiamento,bolsa,convenio,
			valorFinanciamento,dataFinanciamento,numeroBolsas,agenciaFinanciadora,convenio,nomeConvenio,projetoMulticampi,status) 
			VALUES(_titulo,_dataInicio,_dataTermino,_grupoPesquisa,_idAreaConhecimentoCNPq,_idCampus,_resumo,_idOrientador,_financiamento,_bolsa,_convenio,
			_valorFinanciamento,_dataFinanciamento,_numeroBolsas,_agenciaFinanciadora,_nomeConvenio,_projetoMulticampi,1);
	        COMMIT;
	    END;
//
DELIMITER //	    
	CREATE PROCEDURE sp_ProjetoAtualiza(_idProjetoPesquisa int,_titulo varchar(100),_dataInicio date,_dataTermino date,_grupoPesquisa varchar(100),
	_idAreaConhecimentoCNPq int,_idCampus int,_resumo text,_idOrientador int,_financiamento tinyint,_bolsa tinyint, _convenio tinyint,_valorFinanciamento float,
	_dataFinanciamento date,_numeroBolsas int,_agenciaFinanciadora varchar(100),_nomeConvenio varchar(100),_projetoMulticampi tinyint) 
		BEGIN
			DECLARE exit HANDLER FOR SQLEXCEPTION ROLLBACK;
			START TRANSACTION;
			UPDATE ProjetoPesquisa SET titulo = _titulo, dataInicio = _dataInicio, dataTermino = _dataTermino, grupoPesquisa = _grupoPesquisa,
			idAreaConhecimentoCNPq = _idAreaConhecimentoCNPq,idCampus = _idCampus, resumo = _resumo, isOrientador = _idOrientador, financiamento = _financiamento,
			bolsa = _bolsa, convenio = _convenio, valorFinanciamento = _valorFinanciamento,dataFinanciamento = _dataFinanciamento, numeroBolsas = _numeroBolsas,
			agenciaFinanciadora = _agenciaFinanciadora, nomeConvenio = _nomeConvenio,projetoMulticampi = _projetoMulticampi 
			WHERE idProjetoPesquisa = _idProjetoPesquisa;
	        COMMIT;
	    END;
//
DELIMITER //	    
	CREATE PROCEDURE sp_ProjetoApaga(_idProjetoPesquisa int) 
		BEGIN
			DECLARE exit HANDLER FOR SQLEXCEPTION ROLLBACK;
			START TRANSACTION;
			UPDATE ProjetoPesquisa SET status = 0 WHERE idProjetoPesquisa = _idProjetoPesquisa;
	        COMMIT;
	    END;
//

DELIMITER //
	CREATE PROCEDURE sp_LocalDeTrabalho(_nome varchar(100),_idTelefone int,_idAluno int)
		BEGIN
			DECLARE exit HANDLER FOR SQLEXCEPTION ROLLBACK;
			START TRANSACTION;
			INSERT INTO LocalTrabalho(nome,idTelefone,idAluno,status) VALUES(_nome,_idTelefone,_idAluno);
			COMMIT;
		END;
//

DELIMITER //
	CREATE PROCEDURE sp_LocalDeTrabalhoAtualiza(_nome varchar(100),_idTelefone int,_idAluno int,_idLocalTrabalho int)
		BEGIN
			DECLARE exit HANDLER FOR SQLEXCEPTION ROLLBACK;
			START TRANSACTION;
			UPDATE LocalTrabalho SET nome = _nome,idTelefone = _idTelefone,idAluno = _idAluno WHERE idLocalTrabalho = _idLocalTrabalho;
			COMMIT;
		END;
//

DELIMITER //
	CREATE PROCEDURE sp_LocalDeTrabalhoApaga(_idLocalTrabalho int)
		BEGIN
			DECLARE exit HANDLER FOR SQLEXCEPTION ROLLBACK;
			START TRANSACTION;
			UPDATE LocalTrabalho set status = 0 WHERE idLocalTrabalho = _idLocalTrabalho;
			COMMIT;
		END;
//


DELIMITER //
	CREATE PROCEDURE sp_ParticipanteProjeto(_nome varchar(100),_titulacao varchar(100),_observacao varchar(500),_idCampus int,
	_idProjetoPesquisa int)
		BEGIN
			DECLARE exit HANDLER FOR SQLEXCEPTION ROLLBACK;
			START TRANSACTION;
			INSERT INTO ParticipanteProjeto(nome,titulacao,idCampus,observacao,idProjetoPesquisa,status) values(_nome,_titulacao,
			_observacao,_idCampus,_idProjetoPesquisa,1);
			COMMIT;
		END;
//

DELIMITER //
	CREATE PROCEDURE sp_ParticipanteProjetoAtualiza(_nome varchar(100),_titulacao varchar(100),_observacao varchar(500),_idCampus int,
	_idProjetoPesquisa int,_idParticipanteProjeto int)
		BEGIN
			DECLARE exit HANDLER FOR SQLEXCEPTION ROLLBACK;
			START TRANSACTION;
			UPDATE  ParticipantesProjeto SET nome = _nome,titulacao = _titulacao,idCampus = _idCampus,observacao = _observacao,
			idProjetoPesquisa = _idProjetoPesquisa WHERE idParticipanteProjeto = _idParticipanteProjeto;
			
			COMMIT;
		END;
//


DELIMITER //
	CREATE PROCEDURE sp_ParticipanteProjetoApaga(_idParticipanteProjeto int)
		BEGIN
			DECLARE exit HANDLER FOR SQLEXCEPTION ROLLBACK;
			START TRANSACTION;
			UPDATE  ParticipantesProjeto SET status = 0 WHERE idParticipanteProjeto = _idParticipanteProjeto;
			
			COMMIT;
		END;
//



DELIMITER //
	CREATE PROCEDURE sp_CronogramaAtividade(_descricao text,_numeroAtividade int,_dataInicio date,_dataTermino date,_idPlanoDeTrabalho int)
		BEGIN
			DECLARE exit HANDLER FOR SQLEXCEPTION ROLLBACK;
			START TRANSACTION;
			INSERT INTO CronogramaAtividade(descricao,numeroAtividade,idPlanoDeTrabalho,status,dataInicio,dataTermino) VALUES(_descricao,_numeroAtividade,
			_data,_idPlanoDeTrabalho,1,_dataInicio,_dataTermino);
			
			COMMIT;
		END;
//

DELIMITER //
	CREATE PROCEDURE sp_CronogramaAtividadeAtualiza(_descricao text,_numeroAtividade int,_dataInicio date,_dataTermino date,
	_idPlanoDeTrabalho int,_idCronogramaAtividade int)
		BEGIN
			DECLARE exit HANDLER FOR SQLEXCEPTION ROLLBACK;
			START TRANSACTION;
			UPDATE CronogramaAtividade SET descricao = _descricao, numeroAtividade = _numeroAtividade ,
			idPlanoDeTrabalho = _idPlanoDeTrabalho, dataInicio = _dataInicio ,dataTermino =_dataTermino WHERE idCronogramaAtividade = _idCronogramaAtividade;
			
			COMMIT;
		END;
//


DELIMITER //
	CREATE PROCEDURE sp_CronogramaAtividadeApagar(_idCronogramaAtividade int)
		BEGIN
			DECLARE exit HANDLER FOR SQLEXCEPTION ROLLBACK;
			START TRANSACTION;
			UPDATE CronogramaAtividade SET status = 0 WHERE idCronogramaAtividade = _idCronogramaAtividade;
			
			COMMIT;
		END;
//


DELIMITER //
	CREATE PROCEDURE sp_PlanoDeTrabalho(_idAluno int,_idProjetoPesquisa int,_introducao text,_justificativa text,_objetivos text,
	_metodologia text,_resultadosEsperados text,_referenciasBibliograficas text )
		BEGIN
			DECLARE exit HANDLER FOR SQLEXCEPTION ROLLBACK;
			START TRANSACTION;
			INSERT INTO PlanoDeTrabalho(idAluno,idProjetoPesquisa,introducao,justificativa,objetivos,metodoslogia
			,resultadosEsperados,referenciasBibliograficas,status) VALUES (_idAluno,_idProjetoPesquisa,_introducao,_justificativa,_objetivos,
			_metodologia,_resultadosEsperados,_referenciasBibliograficas,1);
			
			
			COMMIT;
		END;
//

DELIMITER //
	CREATE PROCEDURE sp_PlanoDeTrabalhoAtualiza(_idAluno int,_idProjetoPesquisa int,_introducao text,_justificativa text,_objetivos text,
	_metodologia text,_resultadosEsperados text,_referenciasBibliograficas text,_idPlanoDeTrabalho int)
		BEGIN
			DECLARE exit HANDLER FOR SQLEXCEPTION ROLLBACK;
			START TRANSACTION;
			UPDATE PlanoDeTrabalho SET idAluno = _idAluno ,idProjetoPesquisa = _idProjetoPesquisa ,introducao = _introducao ,
			justificativa = _justificativa ,objetivos = _objetivos ,metodoslogia = _metodologia	, resultadosEsperados = _resultadosEsperados,
			referenciasBibliograficas = _referenciasBibliograficas WHERE idPlanoDeTrabalho = _idPlanoDeTrabalho;
			
			
			COMMIT;
		END;
//

DELIMITER //
	CREATE PROCEDURE sp_PlanoDeTrabalhoApaga(_idPlanoDeTrabalho int)
		BEGIN
			DECLARE exit HANDLER FOR SQLEXCEPTION ROLLBACK;
			START TRANSACTION;
			UPDATE PlanoDeTrabalho SET status = 0 WHERE idPlanoDeTrabalho = _idPlanoDeTrabalho;
			
			
			COMMIT;
		END;
//