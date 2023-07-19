package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Train;
import com.example.demo.repository.TrainRepository;





@Service
public class TrainService {

	@Autowired
	private TrainRepository trainrepository;
	Logger logger = LoggerFactory.getLogger(getClass());

	public Train addTrain (Train train) {
		return trainrepository.save(train);
	}

	public List<Train> getContact() {
		List<Train> train = trainrepository.findAll();
		System.out.println("Getting data from DB : " + train);
		logger.info("Getting data from DB : " + train);
		return train;
	}

	public Optional<Train> getTrainbyId(String id) {
		return trainrepository.findById(id);
	}

	public void deleteTrain(Train train) {
		trainrepository.delete(train);
		logger.info("Deleted successfully");
	}


}
