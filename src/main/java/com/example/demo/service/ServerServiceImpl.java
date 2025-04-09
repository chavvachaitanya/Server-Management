package com.example.demo.service;

import com.example.demo.model.Server;
import com.example.demo.repository.ServerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServerServiceImpl implements ServerService {

    @Autowired
    private ServerRepository serverRepository;

    @Override
    public List<Server> getAllServers() {
        return serverRepository.findAll();
    }

    @Override
    public Server saveServer(Server server) {
        return serverRepository.save(server);
    }

    @Override
    public Server updateServer(Long id, Server serverDetails) {
        Server existing = serverRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Server not found with id: " + id));

        existing.setServer_name(serverDetails.getServer_name());
        existing.setIpAddress(serverDetails.getIpAddress());
        existing.setWebsite(serverDetails.getWebsite());
        existing.setRunningBranch(serverDetails.getRunningBranch());
        existing.setChangedBy(serverDetails.getChangedBy());
        existing.setReason(serverDetails.getReason());
        existing.setRunningVersion(serverDetails.getRunningVersion());
        existing.setLastUpdated(serverDetails.getLastUpdated());

        return serverRepository.save(existing);
    }

    @Override
    public void deleteServer(Long id) {
        if (!serverRepository.existsById(id)) {
            throw new RuntimeException("Server not found with id: " + id);
        }
        serverRepository.deleteById(id);
    }
}
