SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `banco_pesquisa` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `banco_pesquisa` ;

-- -----------------------------------------------------
-- Table `banco_pesquisa`.`Campus`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `banco_pesquisa`.`Campus` (
  `idCampus` INT NOT NULL AUTO_INCREMENT ,
  `nome` VARCHAR(100) NOT NULL ,
  `status` TINYINT(1) NULL ,
  PRIMARY KEY (`idCampus`) ,
  UNIQUE INDEX `nome_UNIQUE` (`nome` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `banco_pesquisa`.`CursoArea`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `banco_pesquisa`.`CursoArea` (
  `idCurso` INT NOT NULL AUTO_INCREMENT ,
  `nome` VARCHAR(100) NOT NULL ,
  `sigla` VARCHAR(20) NOT NULL ,
  `status` TINYINT(1) NOT NULL ,
  PRIMARY KEY (`idCurso`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `banco_pesquisa`.`Nacionalidade`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `banco_pesquisa`.`Nacionalidade` (
  `idNacionalidade` INT NOT NULL AUTO_INCREMENT ,
  `nome` VARCHAR(20) NOT NULL ,
  `status` TINYINT(1) NOT NULL ,
  PRIMARY KEY (`idNacionalidade`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `banco_pesquisa`.`Estado`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `banco_pesquisa`.`Estado` (
  `idEstado` INT NOT NULL AUTO_INCREMENT ,
  `nome` VARCHAR(100) NOT NULL ,
  PRIMARY KEY (`idEstado`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `banco_pesquisa`.`Pessoa`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `banco_pesquisa`.`Pessoa` (
  `idPessoa` INT NOT NULL AUTO_INCREMENT ,
  `nome` VARCHAR(100) NOT NULL ,
  `cpf` INT NOT NULL ,
  `rg` VARCHAR(20) NOT NULL ,
  `dataNascimento` DATE NOT NULL ,
  `orgaoExpeditor` VARCHAR(5) NOT NULL ,
  `dataExpedicao` DATE NOT NULL ,
  `status` TINYINT(1) NULL ,
  `idCampus` INT NOT NULL ,
  `idCursoArea` INT NOT NULL ,
  `idNacionalidade` INT NOT NULL ,
  `idEstado` INT NOT NULL ,
  PRIMARY KEY (`idPessoa`) ,
  INDEX `fk_Pessoa_Campus1_idx` (`idCampus` ASC) ,
  INDEX `fk_Pessoa_Curso_Area1_idx` (`idCursoArea` ASC) ,
  INDEX `fk_Pessoa_Nacionalidade1_idx` (`idNacionalidade` ASC) ,
  INDEX `fk_Pessoa_Estado1_idx` (`idEstado` ASC) ,
  CONSTRAINT `fk_Pessoa_Campus1`
    FOREIGN KEY (`idCampus` )
    REFERENCES `banco_pesquisa`.`Campus` (`idCampus` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pessoa_Curso_Area1`
    FOREIGN KEY (`idCursoArea` )
    REFERENCES `banco_pesquisa`.`CursoArea` (`idCurso` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pessoa_Nacionalidade1`
    FOREIGN KEY (`idNacionalidade` )
    REFERENCES `banco_pesquisa`.`Nacionalidade` (`idNacionalidade` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pessoa_Estado1`
    FOREIGN KEY (`idEstado` )
    REFERENCES `banco_pesquisa`.`Estado` (`idEstado` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `banco_pesquisa`.`Cidade`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `banco_pesquisa`.`Cidade` (
  `idCidade` INT NOT NULL AUTO_INCREMENT ,
  `nome` VARCHAR(100) NULL ,
  `idEstado` INT NOT NULL ,
  PRIMARY KEY (`idCidade`) ,
  INDEX `fk_Cidade_Estado_idx` (`idEstado` ASC) ,
  CONSTRAINT `fk_Cidade_Estado`
    FOREIGN KEY (`idEstado` )
    REFERENCES `banco_pesquisa`.`Estado` (`idEstado` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `banco_pesquisa`.`Endereco`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `banco_pesquisa`.`Endereco` (
  `idEndereco` INT NOT NULL AUTO_INCREMENT ,
  `rua` VARCHAR(50) NOT NULL ,
  `bairoo` VARCHAR(50) NOT NULL ,
  `cep` INT NOT NULL ,
  `numero` INT NOT NULL ,
  `complemento` VARCHAR(50) NULL ,
  `idPessoa` INT NOT NULL ,
  `idCidade` INT NOT NULL ,
  `status` TINYINT(1) NOT NULL ,
  PRIMARY KEY (`idEndereco`) ,
  INDEX `fk_Endereco_Pessoa1_idx` (`idPessoa` ASC) ,
  INDEX `fk_Endereco_Cidade1_idx` (`idCidade` ASC) ,
  CONSTRAINT `fk_Endereco_Pessoa1`
    FOREIGN KEY (`idPessoa` )
    REFERENCES `banco_pesquisa`.`Pessoa` (`idPessoa` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Endereco_Cidade1`
    FOREIGN KEY (`idCidade` )
    REFERENCES `banco_pesquisa`.`Cidade` (`idCidade` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `banco_pesquisa`.`Responsavel`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `banco_pesquisa`.`Responsavel` (
  `idResponsavel` INT NOT NULL AUTO_INCREMENT ,
  `nomeResponsavel` VARCHAR(100) NOT NULL ,
  `rgResponsavel` VARCHAR(20) NOT NULL ,
  `orgaoEspeditorResponsavel` VARCHAR(5) NOT NULL ,
  `cpfResponsavel` INT NOT NULL ,
  `nomeMae` VARCHAR(100) NOT NULL ,
  `rgMae` VARCHAR(20) NOT NULL ,
  `orgaoEspeditorMae` VARCHAR(5) NOT NULL ,
  `cpfMae` INT NOT NULL ,
  `status` TINYINT(1) NOT NULL ,
  PRIMARY KEY (`idResponsavel`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `banco_pesquisa`.`Aluno`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `banco_pesquisa`.`Aluno` (
  `idAluno` INT NOT NULL AUTO_INCREMENT ,
  `tituloEleitor` VARCHAR(20) NOT NULL ,
  `secaoEleitoral` VARCHAR(20) NOT NULL ,
  `zonaEleitoral` VARCHAR(20) NOT NULL ,
  `situacaoMilitar` VARCHAR(20) NOT NULL ,
  `certidaoMilitar` VARCHAR(20) NOT NULL ,
  `idPessoa` INT NOT NULL ,
  `status` TINYINT(1) NOT NULL ,
  `idResponsavel` INT NOT NULL ,
  PRIMARY KEY (`idAluno`) ,
  INDEX `fk_Aluno_Pessoa1_idx` (`idPessoa` ASC) ,
  INDEX `fk_Aluno_Responsavel1_idx` (`idResponsavel` ASC) ,
  CONSTRAINT `fk_Aluno_Pessoa1`
    FOREIGN KEY (`idPessoa` )
    REFERENCES `banco_pesquisa`.`Pessoa` (`idPessoa` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Aluno_Responsavel1`
    FOREIGN KEY (`idResponsavel` )
    REFERENCES `banco_pesquisa`.`Responsavel` (`idResponsavel` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `banco_pesquisa`.`Email`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `banco_pesquisa`.`Email` (
  `idEmail` INT NOT NULL AUTO_INCREMENT ,
  `endereco` VARCHAR(100) NULL ,
  `idPessoa` INT NOT NULL ,
  `status` TINYINT(1) NOT NULL ,
  PRIMARY KEY (`idEmail`) ,
  INDEX `fk_Email_Pessoa1_idx` (`idPessoa` ASC) ,
  CONSTRAINT `fk_Email_Pessoa1`
    FOREIGN KEY (`idPessoa` )
    REFERENCES `banco_pesquisa`.`Pessoa` (`idPessoa` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `banco_pesquisa`.`Telefone`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `banco_pesquisa`.`Telefone` (
  `idTelefone` INT NOT NULL AUTO_INCREMENT ,
  `ddd` INT NOT NULL ,
  `numero` INT NOT NULL ,
  `idPessoa` INT NOT NULL ,
  `status` TINYINT(1) NOT NULL ,
  PRIMARY KEY (`idTelefone`) ,
  INDEX `fk_Telefone_Pessoa1_idx` (`idPessoa` ASC) ,
  CONSTRAINT `fk_Telefone_Pessoa1`
    FOREIGN KEY (`idPessoa` )
    REFERENCES `banco_pesquisa`.`Pessoa` (`idPessoa` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `banco_pesquisa`.`Orientador`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `banco_pesquisa`.`Orientador` (
  `idOrientador` INT NOT NULL AUTO_INCREMENT ,
  `matriculaSiape` INT NOT NULL ,
  `localPermanencia` VARCHAR(100) NOT NULL ,
  `formacaoUniversitaria` VARCHAR(100) NOT NULL ,
  `tituloAcademico` VARCHAR(100) NOT NULL ,
  `idPessoa` INT NOT NULL ,
  `status` TINYINT(1) NOT NULL ,
  PRIMARY KEY (`idOrientador`) ,
  INDEX `fk_Orientador_Pessoa1_idx` (`idPessoa` ASC) ,
  CONSTRAINT `fk_Orientador_Pessoa1`
    FOREIGN KEY (`idPessoa` )
    REFERENCES `banco_pesquisa`.`Pessoa` (`idPessoa` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `banco_pesquisa`.`LocalTrabalho`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `banco_pesquisa`.`LocalTrabalho` (
  `idLocalTrabalho` INT NOT NULL AUTO_INCREMENT ,
  `nome` VARCHAR(100) NOT NULL ,
  `idTelefone` INT NOT NULL ,
  `status` TINYINT(1) NOT NULL ,
  `idAluno` INT NOT NULL ,
  PRIMARY KEY (`idLocalTrabalho`) ,
  INDEX `fk_LocalTrabalho_Telefone1_idx` (`idTelefone` ASC) ,
  INDEX `fk_LocalTrabalho_Aluno1_idx` (`idAluno` ASC) ,
  CONSTRAINT `fk_LocalTrabalho_Telefone1`
    FOREIGN KEY (`idTelefone` )
    REFERENCES `banco_pesquisa`.`Telefone` (`idTelefone` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_LocalTrabalho_Aluno1`
    FOREIGN KEY (`idAluno` )
    REFERENCES `banco_pesquisa`.`Aluno` (`idAluno` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `banco_pesquisa`.`AreaConhecimento_CNPq`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `banco_pesquisa`.`AreaConhecimento_CNPq` (
  `idAreaConhecimento_CNPq` INT NOT NULL AUTO_INCREMENT ,
  `nome` VARCHAR(100) NOT NULL ,
  `status` TINYINT(1) NOT NULL ,
  PRIMARY KEY (`idAreaConhecimento_CNPq`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `banco_pesquisa`.`ProjetoPesquisa`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `banco_pesquisa`.`ProjetoPesquisa` (
  `idProjetoPesquisa` INT NOT NULL AUTO_INCREMENT ,
  `titulo` VARCHAR(100) NOT NULL ,
  `dataInicio` DATE NOT NULL ,
  `dataTermino` DATE NOT NULL ,
  `grupoPesquisa` VARCHAR(100) NULL ,
  `idAreaConhecimento_CNPq` INT NOT NULL ,
  `idCampus` INT NOT NULL ,
  `resumo` TEXT NOT NULL ,
  `idOrientador` INT NOT NULL ,
  `Financiamento` TINYINT NULL ,
  `bolsa` TINYINT NULL ,
  `convenio` TINYINT NULL ,
  `valorFinanciamento` DOUBLE NULL ,
  `dataFinanciamento` DATE NULL ,
  `numeroBolsas` INT NULL ,
  `agenciaFinanciadora` VARCHAR(100) NULL ,
  `convenio` TINYINT NULL ,
  `nomeConvenio` VARCHAR(100) NULL ,
  `projetoMulticampi` TINYINT NULL ,
  `status` TINYINT(1) NOT NULL ,
  PRIMARY KEY (`idProjetoPesquisa`) ,
  INDEX `fk_ProjetoPesquisa_AreaConhecimento_CNPq1_idx` (`idAreaConhecimento_CNPq` ASC) ,
  INDEX `fk_ProjetoPesquisa_Campus1_idx` (`idCampus` ASC) ,
  INDEX `fk_ProjetoPesquisa_Orientador1_idx` (`idOrientador` ASC) ,
  CONSTRAINT `fk_ProjetoPesquisa_AreaConhecimento_CNPq1`
    FOREIGN KEY (`idAreaConhecimento_CNPq` )
    REFERENCES `banco_pesquisa`.`AreaConhecimento_CNPq` (`idAreaConhecimento_CNPq` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ProjetoPesquisa_Campus1`
    FOREIGN KEY (`idCampus` )
    REFERENCES `banco_pesquisa`.`Campus` (`idCampus` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ProjetoPesquisa_Orientador1`
    FOREIGN KEY (`idOrientador` )
    REFERENCES `banco_pesquisa`.`Orientador` (`idOrientador` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `banco_pesquisa`.`ParticipatesProjeto`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `banco_pesquisa`.`ParticipatesProjeto` (
  `idParticipatesProjeto` INT NOT NULL AUTO_INCREMENT ,
  `nome` VARCHAR(100) NOT NULL ,
  `titulacao` VARCHAR(100) NOT NULL ,
  `observacao` VARCHAR(500) NULL ,
  `idCampus` INT NOT NULL ,
  `idProjetoPesquisa` INT NOT NULL ,
  `status` TINYINT(1) NOT NULL ,
  PRIMARY KEY (`idParticipatesProjeto`) ,
  INDEX `fk_ParticipatesProjeto_Campus1_idx` (`idCampus` ASC) ,
  INDEX `fk_ParticipatesProjeto_ProjetoPesquisa1_idx` (`idProjetoPesquisa` ASC) ,
  CONSTRAINT `fk_ParticipatesProjeto_Campus1`
    FOREIGN KEY (`idCampus` )
    REFERENCES `banco_pesquisa`.`Campus` (`idCampus` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ParticipatesProjeto_ProjetoPesquisa1`
    FOREIGN KEY (`idProjetoPesquisa` )
    REFERENCES `banco_pesquisa`.`ProjetoPesquisa` (`idProjetoPesquisa` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `banco_pesquisa`.`PlanoDeTrabalho`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `banco_pesquisa`.`PlanoDeTrabalho` (
  `idPlanoDeTrabalho` INT NOT NULL AUTO_INCREMENT ,
  `idAluno` INT NOT NULL ,
  `idProjetoPesquisa` INT NOT NULL ,
  `introducao` TEXT NOT NULL ,
  `justificativa` TEXT NOT NULL ,
  `objetivos` TEXT NOT NULL ,
  `metodologia` VARCHAR(45) NOT NULL ,
  `resultadosEsperados` TEXT NOT NULL ,
  `referenciasBibliograficas` TEXT NOT NULL ,
  `status` TINYINT(1) NOT NULL ,
  `daraInicial` VARCHAR(10) NOT NULL ,
  `dataFinal` VARCHAR(10) NOT NULL ,
  PRIMARY KEY (`idPlanoDeTrabalho`) ,
  INDEX `fk_PlanoDeTrabalho_Aluno1_idx` (`idAluno` ASC) ,
  INDEX `fk_PlanoDeTrabalho_ProjetoPesquisa1_idx` (`idProjetoPesquisa` ASC) ,
  CONSTRAINT `fk_PlanoDeTrabalho_Aluno1`
    FOREIGN KEY (`idAluno` )
    REFERENCES `banco_pesquisa`.`Aluno` (`idAluno` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PlanoDeTrabalho_ProjetoPesquisa1`
    FOREIGN KEY (`idProjetoPesquisa` )
    REFERENCES `banco_pesquisa`.`ProjetoPesquisa` (`idProjetoPesquisa` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `banco_pesquisa`.`CronogramaDeAtividades`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `banco_pesquisa`.`CronogramaDeAtividades` (
  `idCronogramaDeAtividades` INT NOT NULL AUTO_INCREMENT ,
  `descricao` TEXT NOT NULL ,
  `numeroAtividade` INT NOT NULL ,
  `status` TINYINT NOT NULL ,
  `idPlanoDeTrabalho` INT NOT NULL ,
  `data` VARCHAR(10) NOT NULL ,
  PRIMARY KEY (`idCronogramaDeAtividades`) ,
  INDEX `fk_CronogramaDeAtividades_PlanoDeTrabalho1_idx` (`idPlanoDeTrabalho` ASC) ,
  CONSTRAINT `fk_CronogramaDeAtividades_PlanoDeTrabalho1`
    FOREIGN KEY (`idPlanoDeTrabalho` )
    REFERENCES `banco_pesquisa`.`PlanoDeTrabalho` (`idPlanoDeTrabalho` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `banco_pesquisa` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
