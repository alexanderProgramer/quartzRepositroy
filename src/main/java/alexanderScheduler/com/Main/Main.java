package alexanderScheduler.com.Main;
import org.quartz.*;

import org.quartz.impl.StdSchedulerFactory;

import java.time.LocalTime;
import java.util.Date;

import static java.time.temporal.ChronoUnit.MINUTES;
import static org.quartz.DateBuilder.futureDate;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;

public class Main {
    public static void main(String[] args) {
    try {
// Creacion de una instacia de Scheduler
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        System.out.println("Iniciando Scheduler...");

// Creacion una instacia de JobDetail
        JobDetail jobDetail = JobBuilder.newJob(HolaJob.class)
                .withIdentity("HolaJob",  Scheduler.DEFAULT_GROUP)
                .build();

// Creacion de un Trigger donde indicamos
//que el Job se
// ejecutara de inmediato y a partir de ahi en lapsos
// de 5 segundos por 10 veces mas.
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("miTrigger", Scheduler.DEFAULT_GROUP)
                .startNow()
                .withSchedule(simpleSchedule()
                        .withIntervalInSeconds(5)
                        .repeatForever())
                .build();

        // Crea un disparador (trigger) para ejecutar el trabajo a las 10:00 AM del 1 de enero de 2023
        Trigger trigger2 = TriggerBuilder.newTrigger()
                .withIdentity("myTrigger", Scheduler.DEFAULT_GROUP)
                .withSchedule(simpleSchedule()
                .withIntervalInSeconds(5)
                .repeatForever())
                .startAt(DateBuilder.dateOf(22, 5, 0, 29, 6, 2024))

               //.startAt(DateBuilder.dateOf(20, 38, 0, 29, 6, 2024))
                //.withSchedule(CronScheduleBuilder.cronSchedule("0 54 20 ? * MON-SUN 2024-2030"))

                .build();
                // other creation
        LocalTime localTime = LocalTime.now();
        int minute = localTime.getMinute();
        int hour = localTime.getHour();
        int second = localTime.getSecond();
        //minute = 28;
        System.out.println("Minute captured is: "+ minute);
                 Trigger trigger3 = TriggerBuilder.newTrigger()
                .withIdentity("myTrigger", Scheduler.DEFAULT_GROUP)
                .withSchedule(CronScheduleBuilder.cronSchedule("0 0/10 1,2 ? * MON-SUN 2024-2026"))// segundos minutos horas meses dias anio
                .startAt(DateBuilder.dateOf(1, 40, 0, 30, 6, 2024))
                .build();

// Registro dentro del Schedulergi

        System.out.println("triguer start time is: "+  trigger2.getStartTime());
        scheduler.scheduleJob(jobDetail, trigger3);
        scheduler.start();
        System.out.println("triguer start time is: "+  new Date());

// Damos tiempo a que el Trigger registrado
//termine su periodo
// de vida dentro del scheduler
        System.out.println("max valor long "+ Long.MAX_VALUE);
        //Thread.sleep(60000);

// Detenemos la ejecución de la
// instancia de Scheduler
        //scheduler.awaitTermination(1, TimeUnit.MINUTES); // Espera máximo 1 minuto
        //scheduler.shutdown();

    } catch(Exception e) {
        System.out.println("Ocurrió una excepción: "+ e.getMessage());
    }
}
}
