package com.example.demo;

import com.example.demo.model.Server;
import com.example.demo.service.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servers")
public class ServerController {

    @Autowired
    private ServerService serverService;

    @GetMapping
    public List<Server> getAllServers() {
        return serverService.getAllServers();
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Server createServer(@RequestBody Server server) {
        return serverService.saveServer(server);
    }

    @PutMapping("/{id}") // 🔄 Fixed duplicate `/servers` in path
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> updateServer(@PathVariable Long id, @RequestBody Server serverDetails) {
        Server updated = serverService.updateServer(id, serverDetails);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteServer(@PathVariable Long id) {
        serverService.deleteServer(id);
        return ResponseEntity.ok().build();
    }
}
