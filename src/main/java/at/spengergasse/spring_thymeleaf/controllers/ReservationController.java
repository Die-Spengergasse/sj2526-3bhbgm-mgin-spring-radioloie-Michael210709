package at.spengergasse.spring_thymeleaf.controllers;

import at.spengergasse.spring_thymeleaf.entities.*;
import at.spengergasse.spring_thymeleaf.repositories.DeviceRepository;
import at.spengergasse.spring_thymeleaf.repositories.PatientRepository;
import at.spengergasse.spring_thymeleaf.repositories.ReservationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/reservation")
public class ReservationController {

    private final ReservationRepository reservationRepository;
    private final PatientRepository patientRepository;
    private final DeviceRepository deviceRepository;

    public ReservationController(ReservationRepository r,
                                 PatientRepository p,
                                 DeviceRepository d) {
        this.reservationRepository = r;
        this.patientRepository = p;
        this.deviceRepository = d;
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("reservations", reservationRepository.findAll());
        return "reservationlist";
    }

    @GetMapping("/add_reservation")
    public String addForm(Model model) {
        model.addAttribute("patients", patientRepository.findAll());
        model.addAttribute("devices", deviceRepository.findAll());
        return "add_reservation";
    }

    @PostMapping("/add_reservation")
    public String save(@RequestParam Long patientId,
                       @RequestParam Long deviceId,
                       @RequestParam String date,
                       @RequestParam String startTime,
                       @RequestParam String endTime) {

        Reservation r = new Reservation();

        r.setPatient(patientRepository.findById(patientId).orElse(null));
        r.setDevice(deviceRepository.findById(deviceId).orElse(null));

        r.setDate(LocalDate.parse(date));
        r.setStartTime(LocalDateTime.parse(startTime));
        r.setEndTime(LocalDateTime.parse(endTime));

        reservationRepository.save(r);

        return "redirect:/reservation/list";
    }
}