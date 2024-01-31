package af.cmr.indyli.akademia.business.service;

import af.cmr.indyli.akademia.business.exception.AkdemiaBusinessException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.nio.file.AccessDeniedException;
import java.util.List;

public interface IAbstractAkdemiaService<Entity, BasicDTO, FullDTO extends BasicDTO, IEntityDAO extends JpaRepository<Entity, Integer>> {
	public FullDTO create(FullDTO ent) throws AkdemiaBusinessException;
	public FullDTO update(FullDTO entToUpdate) throws AkdemiaBusinessException, AccessDeniedException;
	public void deleteById(int id) throws AkdemiaBusinessException, AccessDeniedException;
	public List<BasicDTO> findAll();
	public FullDTO findById(int id) throws AkdemiaBusinessException;
	public boolean ifEntityExistById(int id) throws AkdemiaBusinessException;
	public <T extends BasicDTO> T findById(int id, Class<T> type) throws AkdemiaBusinessException;
	public IEntityDAO getDAO();
}
