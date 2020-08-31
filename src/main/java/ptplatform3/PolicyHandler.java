package ptplatform3;

import ptplatform3.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//HNR-START
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
//HNR--END-

@Service
public class PolicyHandler{
    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }

    //HNR-START
    @Autowired
    PttrainerRepository pttrainerRepository;
    //HNR--END-

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPtOrderAccepted_PtScheduleConfirmationRequest(@Payload PtOrderAccepted ptOrderAccepted){

        if(ptOrderAccepted.isMe()){
            System.out.println("##### listener PtScheduleConfirmationRequest : " + ptOrderAccepted.toJson());
            //HNR-START
            Pttrainer pttrainer = new Pttrainer();
            pttrainer.setPtManagerId(ptOrderAccepted.getId());
            pttrainer.setPtOrderId(ptOrderAccepted.getPtOrderId());
            pttrainer.setStatus("SCHEDULE_CONFIRMED");
            
            Calendar cal = Calendar.getInstance();
            cal.setTime(new Date());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
            cal.add(Calendar.DATE, 1);
            String now = simpleDateFormat.format(cal.getTime());
            pttrainer.setPtClassDate(now);

            pttrainerRepository.save(pttrainer);
            //HNR--END-
        }
    }

}
