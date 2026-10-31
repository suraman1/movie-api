package com.app.movies.Services;

import com.app.movies.Models.Movie;
import com.app.movies.Models.Review;
import com.app.movies.Repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Review createReview(String reviewBody, String imdbid) {
        Review review = reviewRepository.insert(new Review(reviewBody));
        reviewRepository.insert(review);
        mongoTemplate.update(Movie.class).matching(Criteria.where("imdbId").is(imdbid)).apply(new Update().push("reviewsId").value(review)).first();
        return review;
    }
}
