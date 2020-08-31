package ptplatform3;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Entity
@Table(name="Pttrainer_table")
public class Pttrainer {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long ptOrderId;
    private Long ptManagerId;
    private String status;
    private String ptResult;
    private String ptClassDate;
    // private Long ptTrainerId4Cancel;


    @PostPersist
    public void onPostPersist(){
        if(this.getStatus().equals("SCHEDULE_CONFIRMED")) {
            System.out.println("[HNR_DEBUG] ######################################");
            System.out.println("[HNR_DEBUG] ######### SCHEDULE_CONFIRMED #########");
            System.out.println("[HNR_DEBUG] ######################################");
            final PtScheduleConfirmed ptScheduleConfirmed = new PtScheduleConfirmed();
            BeanUtils.copyProperties(this, ptScheduleConfirmed);
            ptScheduleConfirmed.publishAfterCommit();
        }
        // else if(this.getStatus().equals("SCHEDULE_CANCELED")) {

        //     System.out.println("[HNR_DEBUG] ##################################################");
        //     System.out.println("[HNR_DEBUG] ######### SCHEDULE_CANCELED (Feign_POST) #########");
        //     System.out.println("[HNR_DEBUG] ##################################################");
        //     //HNR-START
        //     @Autowired
        //     PttrainerRepository pttrainerRepository;

        //     Optional<Ptorder> pttrainers = pttrainerRepository.findById(this.getPtOrderId());
        //     pttrainers.get().setPtManagerId(this.getId());
        //     pttrainers.get().setPtTrainerId(this.getPtTrainerId());
        //     pttrainers.get().setStatus("SCHEDULE_CANCELED");
        //     pttrainerRepository.save(pttrainers.get());

        //     final PtScheduleCanceled ptScheduleCanceled = new PtScheduleCanceled();
        //     BeanUtils.copyProperties(this, ptScheduleCanceled);
        //     ptScheduleCanceled.publishAfterCommit();
        //     //HNR--END-
        // //     try {
        // //         System.out.println("[HNR_DEBUG] ##################################################");
        // //         System.out.println("[HNR_DEBUG] ######### SCHEDULE_CANCELED (Feign_POST) #########");
        // //         System.out.println("[HNR_DEBUG] ##################################################");
        // //         // PtScheduleConfirmed ptScheduleConfirmed = new PtScheduleConfirmed();
        // //         // BeanUtils.copyProperties(this, ptScheduleConfirmed);
        // //         // ptScheduleConfirmed.publishAfterCommit();
        // //         // ptOrderId에 ptTrainerId를 담아서 보냄. 상태 변경을 위해서...

        // //         final Optional<Pttrainer> pt = pttrainerRepository.findById(ptOrderId);
        // //         pt.get().setStatus("SCHEDULE_CANCELED");
        // //         pttrainerRepository.save(pt.get());
        // //     } catch (final Exception e) {
        // //         e.printStackTrace();
        // //     }            
        // }
    }

    @PostUpdate
    public void onPostUpdate(){
        if(this.getStatus().equals("RESULT_CREATED")) {
            System.out.println("[HNR_DEBUG] ##################################");
            System.out.println("[HNR_DEBUG] ######### RESULT_CREATED #########");
            System.out.println("[HNR_DEBUG] ##################################");
            final PtResultCreated ptResultCreated = new PtResultCreated();
            BeanUtils.copyProperties(this, ptResultCreated);
            ptResultCreated.publishAfterCommit();
        }
        else if(this.getStatus().equals("SCHEDULE_CANCELED")) {
            System.out.println("[HNR_DEBUG] #####################################");
            System.out.println("[HNR_DEBUG] ######### SCHEDULE_CANCELED #########");
            System.out.println("[HNR_DEBUG] #####################################");
            final PtScheduleCanceled ptScheduleCanceled = new PtScheduleCanceled();
            BeanUtils.copyProperties(this, ptScheduleCanceled);
            ptScheduleCanceled.publishAfterCommit();
        }
    }


    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }
    public Long getPtOrderId() {
        return ptOrderId;
    }

    public void setPtOrderId(final Long ptOrderId) {
        this.ptOrderId = ptOrderId;
    }
    public Long getPtManagerId() {
        return ptManagerId;
    }

    public void setPtManagerId(final Long ptManagerId) {
        this.ptManagerId = ptManagerId;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }
    public String getPtResult() {
        return ptResult;
    }

    public void setPtResult(final String ptResult) {
        this.ptResult = ptResult;
    }
    public String getPtClassDate() {
        return ptClassDate;
    }

    public void setPtClassDate(final String ptClassDate) {
        this.ptClassDate = ptClassDate;
    }

    // public Long getPtTrainerId4Cancel() {
    //     return ptTrainerId4Cancel;
    // }

    // public void setPtTrainerId4Cancel(Long ptTrainerId4Cancel) {
    //     this.ptTrainerId4Cancel = ptTrainerId4Cancel;
    // }

}
