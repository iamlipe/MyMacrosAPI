package com.iamlipe.MyMacros.infrastructure.services;

import com.iamlipe.MyMacros.domain.entities.info.Info;
import com.iamlipe.MyMacros.domain.entities.info.InfoRequestDTO;
import com.iamlipe.MyMacros.domain.entities.user.User;
import com.iamlipe.MyMacros.domain.enums.ActivityLevel;
import com.iamlipe.MyMacros.domain.enums.Gender;
import com.iamlipe.MyMacros.domain.enums.Goal;
import com.iamlipe.MyMacros.infrastructure.exceptions.NotFound;
import com.iamlipe.MyMacros.domain.repositories.InfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.UUID;

@Service
public class InfoService {

    @Autowired
    private InfoRepository repository;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Info insertInfo(User user, InfoRequestDTO data) {
        Gender gender = data.gender();
        LocalDate birhtDate = LocalDate.parse(data.birthDate(), formatter);
        ActivityLevel activityLevel = data.activityLevel();
        Double height = data.height();
        Double wieght = data.weight();
        Goal goal = data.goal();

        Info info = new Info(gender, birhtDate, activityLevel, height, wieght, goal, user);

        return repository.save(info);
    }

    public Info updateInfo(UUID infoId, InfoRequestDTO data) {
        Info info = findById(infoId);

        info.setGoal(data.goal());
        info.setGender(data.gender());
        info.setHeight(data.height());
        info.setWeight(data.weight());
        info.setActivityLevel(data.activityLevel());
        info.setBirthDate(LocalDate.parse(data.birthDate(), formatter));

        return repository.save(info);
    }

    public Info findById(UUID id) {
        Optional<Info> info = repository.findById(id);
        return info.orElseThrow(() -> new NotFound(id.toString()));
    }
}
