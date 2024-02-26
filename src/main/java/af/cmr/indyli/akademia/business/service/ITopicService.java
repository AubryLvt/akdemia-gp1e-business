package af.cmr.indyli.akademia.business.service;

import af.cmr.indyli.akademia.business.dao.ITopicRepository;
import af.cmr.indyli.akademia.business.dto.basic.TopicBasicDTO;
import af.cmr.indyli.akademia.business.dto.full.TopicFullDTO;
import af.cmr.indyli.akademia.business.entity.Topic;

/**
 * Interface extending the IAbstractAkdemiaService interface for managing
 * planning, providing specific operations for {@link Topic} entity.
 *
 * @see IAbstractAkdemiaService
 */
public interface ITopicService extends IAbstractAkdemiaService<Topic, TopicBasicDTO, TopicFullDTO, ITopicRepository> {

}