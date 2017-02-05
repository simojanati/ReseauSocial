package com.reseau.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reseau.model.Notification;

public interface INotificationRepository extends JpaRepository<Notification, Long> {

}
