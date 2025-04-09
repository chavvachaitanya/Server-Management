package com.example.demo.service;

import com.example.demo.model.Server;

import java.util.List;

public interface ServerService {
    List<Server> getAllServers();
    Server saveServer(Server server);
    Server updateServer(Long id, Server serverDetails);
    void deleteServer(Long id);
}
