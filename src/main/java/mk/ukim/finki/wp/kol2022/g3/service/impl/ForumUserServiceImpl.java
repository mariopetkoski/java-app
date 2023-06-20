package mk.ukim.finki.wp.kol2022.g3.service.impl;

import mk.ukim.finki.wp.kol2022.g3.model.ForumUser;
import mk.ukim.finki.wp.kol2022.g3.model.ForumUserType;
import mk.ukim.finki.wp.kol2022.g3.model.Interest;
import mk.ukim.finki.wp.kol2022.g3.repository.ForumUserRepository;
import mk.ukim.finki.wp.kol2022.g3.repository.InterestRepository;
import mk.ukim.finki.wp.kol2022.g3.service.ForumUserService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ForumUserServiceImpl implements ForumUserService {

    private final ForumUserRepository forumUserRepository;
    private final InterestRepository interestRepository;

    public ForumUserServiceImpl(ForumUserRepository forumUserRepository, InterestRepository interestRepository) {
        this.forumUserRepository = forumUserRepository;
        this.interestRepository = interestRepository;
    }

    @Override
    public List<ForumUser> listAll() {
        return this.forumUserRepository.findAll();
    }

    @Override
    public Optional<ForumUser> findById(Long id) {
        return this.forumUserRepository.findById(id);
    }

    @Override
    public ForumUser create(String name, String email, String password, ForumUserType type, List<Long> interestId, LocalDate birthday) {

        List<Interest> interests = this.interestRepository.findAllById(interestId);
        ForumUser forumUser = new ForumUser(name, email, password, type, interests, birthday);
        return this.forumUserRepository.save(forumUser);
    }

    @Override
    public ForumUser update(Long id, String name, String email, String password, ForumUserType type, List<Long> interestId, LocalDate birthday) {
        ForumUser forumUser = this.forumUserRepository.findById(id).get();
        forumUser.setName(name);
        forumUser.setEmail(email);
        forumUser.setPassword(password);
        forumUser.setType(type);
        List<Interest> interests = this.interestRepository.findAllById(interestId);
        forumUser.setInterests(interests);
        forumUser.setBirthday(birthday);
        return this.forumUserRepository.save(forumUser);
    }

    @Override
    public ForumUser delete(Long id) {
        ForumUser forumUser = this.forumUserRepository.findById(id).get();
        this.forumUserRepository.delete(forumUser);
        return forumUser;
    }

    @Override
    public List<ForumUser> filter(Long interestId, Integer age) {
        return new ArrayList<>();
    }
}
