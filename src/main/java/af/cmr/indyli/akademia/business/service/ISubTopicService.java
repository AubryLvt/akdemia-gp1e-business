package af.cmr.indyli.akademia.business.service;

import af.cmr.indyli.akademia.business.dao.ISubTopicRepository;
import af.cmr.indyli.akademia.business.dto.basic.SubTopicBasicDTO;
import af.cmr.indyli.akademia.business.dto.full.SubTopicFullDTO;
import af.cmr.indyli.akademia.business.entity.SubTopic;

/**
 * Interface extending the IAbstractAkdemiaService interface for managing sub
 * topics, providing specific operations for {@link SubTopic} entity.
 *
 * @see IAbstractAkdemiaService
 */
public interface ISubTopicService
		extends IAbstractAkdemiaService<SubTopic, SubTopicBasicDTO, SubTopicFullDTO, ISubTopicRepository> {

}