package br.com.mercuryviagens.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mercuryviagens.domain.PacoteViagem;
import br.com.mercuryviagens.repository.PacoteViagemRepository;
import br.com.mercuryviagens.service.exception.ObjectNotFoundException;

@Service
public class PacoteViagemService {

	@Autowired
	private PacoteViagemRepository repo;
	
	public PacoteViagem findById(Integer id) {
		Optional<PacoteViagem> pacoteViagem = repo.findById(id);
		return pacoteViagem.orElseThrow(
				() -> new ObjectNotFoundException(
						"Objeto nao encontrado: "+ id + ". Tipo: "+ PacoteViagem.class.getName()
						)
				);
	}
	
	public List<PacoteViagem> findAll() {
		return repo.findAll();
	}
	
	public PacoteViagem save(PacoteViagem pacoteViagem) {
		return repo.save(pacoteViagem);
	}
	
	public PacoteViagem update(PacoteViagem pacoteViagem) {
		PacoteViagem newPacoteViagem = findById(pacoteViagem.getId());
		updatePacoteViagem(pacoteViagem, newPacoteViagem);
		return repo.save(newPacoteViagem);
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
	
	private PacoteViagem updatePacoteViagem(PacoteViagem oldPacote, PacoteViagem newPacote) {
		newPacote.setDestino(oldPacote.getDestino());
		newPacote.setDataIda(oldPacote.getDataIda());
		newPacote.setDataVolta(oldPacote.getDataVolta());
		newPacote.setPreco(oldPacote.getPreco());
		newPacote.setNumMaxPrestacoes(oldPacote.getNumMaxPrestacoes());
		return newPacote;
	}
	
	
}
