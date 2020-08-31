package ptplatform3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

 @RestController
 public class PttrainerController {

    //HNR-START
    @Autowired
    PttrainerRepository pttrainerRepository;
    //HNR--END-


        // else if(this.getStatus().equals("SCHEDULE_CANCELED")) {
        //     try {
        //         System.out.println("[HNR_DEBUG] ##################################################");
        //         System.out.println("[HNR_DEBUG] ######### SCHEDULE_CANCELED (Feign_POST) #########");
        //         System.out.println("[HNR_DEBUG] ##################################################");
        //         // PtScheduleConfirmed ptScheduleConfirmed = new PtScheduleConfirmed();
        //         // BeanUtils.copyProperties(this, ptScheduleConfirmed);
        //         // ptScheduleConfirmed.publishAfterCommit();
        //         // ptOrderId에 ptTrainerId를 담아서 보냄. 상태 변경을 위해서...

        //         final Optional<Pttrainer> pt = pttrainerRepository.findById(ptOrderId);
        //         pt.get().setStatus("SCHEDULE_CANCELED");
        //         pttrainerRepository.save(pt.get());
        //     } catch (final Exception e) {
        //         e.printStackTrace();
        //     }            
        // }


    // @RequestMapping(method=RequestMethod.POST, path="/pttrainers")
    // public void scheduleCancellation(@RequestParam (value="orderId", required=false, defaultValue="0") Long ptxTrainerId) {

    //     Pttrainer pttrainer = pttrainerRepository.findById(ptxTrainerId);
    //     pttrainer.setStatus("SCHEDULE_CANCELED");
    //     pttrainerRepository.save(pttrainer);

    // }
    //HNR-E

 }
