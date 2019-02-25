package com.kloudone.dealer.service.impl;

import com.kloudone.dealer.service.DealerService;
import com.kloudone.dealer.domain.Dealer;
import com.kloudone.dealer.repository.DealerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing Dealer.
 */
@Service
@Transactional
public class DealerServiceImpl implements DealerService {

    private final Logger log = LoggerFactory.getLogger(DealerServiceImpl.class);

    private final DealerRepository dealerRepository;

    public DealerServiceImpl(DealerRepository dealerRepository) {
        this.dealerRepository = dealerRepository;
    }

    /**
     * Save a dealer.
     *
     * @param dealer the entity to save
     * @return the persisted entity
     */
    @Override
    public Dealer save(Dealer dealer) {
        log.debug("Request to save Dealer : {}", dealer);
        return dealerRepository.save(dealer);
    }

    /**
     * Get all the dealers.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<Dealer> findAll() {
        log.debug("Request to get all Dealers");
        return dealerRepository.findAll();
    }


    /**
     * Get one dealer by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Dealer> findOne(Long id) {
        log.debug("Request to get Dealer : {}", id);
        return dealerRepository.findById(id);
    }

    /**
     * Delete the dealer by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Dealer : {}", id);        dealerRepository.deleteById(id);
    }
}
