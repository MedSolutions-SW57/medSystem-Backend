package com.losluminosos.medsystem.iam.infrastructure.hashing.bcrypt;

import com.losluminosos.medsystem.iam.application.internal.outboundservices.hashing.HashingService;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface BCryptHashingService extends HashingService, PasswordEncoder {

}
