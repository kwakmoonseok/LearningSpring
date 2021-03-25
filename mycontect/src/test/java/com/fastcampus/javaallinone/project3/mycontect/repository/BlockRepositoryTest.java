package com.fastcampus.javaallinone.project3.mycontect.repository;

import com.fastcampus.javaallinone.project3.mycontect.domain.Block;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import javax.persistence.Access;
import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class BlockRepositoryTest {
    @Autowired
    private BlockRepository blockRepository;

    @Test
    void crud(){
        Block block = new Block();
        block.setName("martin");
        block.setReason("친하지 않음");
        block.setStartDate(LocalDate.now());
        block.setEndDate(LocalDate.now());

        blockRepository.save(block);

        List<Block> blocks = blockRepository.findAll();
        Assert.isTrue(blocks.size() == 1, "SizeError");
        Assert.isTrue(blocks.get(0).getName() == "martin", "nameError");
    }
}
