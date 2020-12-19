package br.com.secretariadeeducacao.apiescolasecretariadeeducacao.service.escola;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.Repository.EscolaRepository;
import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.controller.dto.form.EscolaForm;
import br.com.secretariadeeducacao.apiescolasecretariadeeducacao.model.Escola;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class EscolaSpringDataJPAService implements EscolaService {

	private EscolaRepository escolaRepository;

	public EscolaSpringDataJPAService(EscolaRepository escolaRepository) {
		this.escolaRepository = escolaRepository;

	}

	@Override
	public List<Escola> findAll() {
		log.info("Starting Method findAll in EscolaSpringDataJPAService");
		log.info("finishing Method findAll in EscolaSpringDataJPAService");
		return this.escolaRepository.findAll();

	}

	@Override
	public Escola findById(Integer id) {
		log.info("Starting Method findById in EscolaSpringDataJPAService");
		log.info("Parameter:{}", id);
		log.info("Finding Escola by id on EscolaRepository");
		Escola escola = escolaRepository.findById(id).orElseThrow(() -> new RuntimeException("Objeto não encontrado"));
		log.info("Finishing Method findById in EscolaSpringDataJPAService");
		return escola;
	}

	@Override
	public Escola insert(Escola escolaObj) {
		escolaObj = escolaRepository.save(escolaObj);
		return escolaObj;
	}

	

	@Override
	public Escola update(Escola escolaObj) {
		Escola newObj = find(escolaObj.getId());
		updateData(newObj, escolaObj);
		return escolaRepository.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			escolaRepository.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não é possível excluir");
		}
	}

	private void updateData(Escola newObj, Escola escolaObj) {
		newObj.setId(escolaObj.getId());
		
	}
	
	public Escola find(Integer id) {
		Optional<Escola> obj = escolaRepository.findById(id);
		return obj.orElseThrow(() -> new RuntimeException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Escola.class.getName()));
	}
	
	@Override
	public Escola fromDto(EscolaForm escolaForm) {

		return new Escola(escolaForm.getNome());
	}

}
