package com.example.threadblocksimulator.controller;
import com.example.threadblocksimulator.service.ThreadBlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/thread-block")
public class ThreadBlockController {

	    @Autowired
	    private com.example.threadblocksimulator.service.ThreadBlockService threadBlockService;

	    @GetMapping("/simulate")
	    public String simulateBlockedThread(@RequestParam long sleepMillis) {
	        try {
	            threadBlockService.simulateBlockedThread(sleepMillis);
	            return "Thread block simulation completed.";
	        } catch (Exception e) {
	            return "Failed to simulate thread block: " + e.getMessage();
	        }
	    }

}
