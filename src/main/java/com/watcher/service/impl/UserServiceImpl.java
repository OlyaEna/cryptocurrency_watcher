package com.watcher.service.impl;

import com.watcher.dto.user.UserRequest;
import com.watcher.exceptions.NoSuchSymbolException;
import com.watcher.exceptions.NonUniqueUsernameException;
import com.watcher.model.entity.User;
import com.watcher.model.repository.CurrencyRepository;
import com.watcher.model.repository.UserRepository;
import com.watcher.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@EnableScheduling
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final CurrencyRepository currencyRepository;

    @Override
    public void saveUserToDB(UserRequest userRequest) {
        if (userRequest != null) {
            User user = userRepository.findUserByUsername(userRequest.getUsername());
            List<String> symbols = currencyRepository.findAllSymbols();
            if (user == null) {
                user = new User();
                user.setUsername(userRequest.getUsername());
                if (symbols.contains(userRequest.getSymbol())) {
                    user.setSymbol(userRequest.getSymbol());
                } else {
                    throw new NoSuchSymbolException("There are no such symbol. Try again.");
                }
                user.setPrice_usd(currencyRepository.findPriceBySymbol(userRequest.getSymbol()));
                userRepository.save(user);
                log.info("User saved:" + user);
            } else {
                throw new NonUniqueUsernameException("Username is already taken. Try again.");
            }
        }
    }

    @Scheduled(cron = "${interval-in-cron}")
    public void notifyUser() {
        List<User> users = userRepository.findAll();
        for (User user : users) {
            double price = currencyRepository.findPriceBySymbol(user.getSymbol());
            double userPrice = user.getPrice_usd();
            double percent = Math.abs(100 - (price * 100 / userPrice));
            if (percent > 1) {
                log.warn("Percent change:" + user.getSymbol() + ", " + user.getUsername() + ", " + percent);
            }
        }
    }


}
