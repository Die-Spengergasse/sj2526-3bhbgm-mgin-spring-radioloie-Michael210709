package at.spengergasse.spring_thymeleaf.controllers;

import at.spengergasse.spring_thymeleaf.entities.Device;
import at.spengergasse.spring_thymeleaf.entities.DeviceRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/device")
public class DeviceController {
    private final DeviceRepository deviceRepository;

    public DeviceController(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    @GetMapping("/list")
    public String devices(Model model) {
        model.addAttribute("devices", deviceRepository.findAll());
        return "devlist";
    }

    @GetMapping("/add")
    public String addDevice(Model model) {
        model.addAttribute("device", new Device());
        return "add_device";
    }

    @PostMapping("/add")
    public String addDevice(@ModelAttribute("device") Device device) {
        deviceRepository.save(device);
        return  "redirect:/device/list";
    }
}
