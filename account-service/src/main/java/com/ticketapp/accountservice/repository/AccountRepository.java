package com.ticketapp.accountservice.repository;

import com.ticketapp.accountservice.model.Account;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface AccountRepository  extends CassandraRepository<Account,String> {

}
