package af.cmr.indyli.akademia.business.dto.basic;

import af.cmr.indyli.akademia.business.dto.IDTO;

import java.util.Date;

public class EvaluationBasicDTO implements IDTO {
    private Integer id;
    private Integer sessionScore;
    private Integer trainerScore;
    private Date creationDate;
    private Date updateDate;


    public EvaluationBasicDTO() {
        super();
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSessionScore() {
        return sessionScore;
    }

    public void setSessionScore(Integer sessionScore) {
        this.sessionScore = sessionScore;
    }

    public Integer getTrainerScore() {
        return trainerScore;
    }

    public void setTrainerScore(Integer trainerScore) {
        this.trainerScore = trainerScore;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }


}
