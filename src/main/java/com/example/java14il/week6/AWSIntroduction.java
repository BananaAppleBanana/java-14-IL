package com.example.java14il.week6;


/**
 *  server room
 *
 *  AWS
 *      IAM =>
 *      1. EC2  + Auto scaling group
 *      2. S3 (images, videos, documents) <-> S3 glacier
 *      3. SQS, SNS
 *      4. Security Group(stateful)  =>  inbound + outbound
 *      5. RDS(oracle, mysql, postgresql)
 *      6. (Lambda)
 *      7. Application Loadbalancer => ALB (ip + port) => /emp  -> target group[EC2, EC2, EC2, EC2]
 *      8. API Gateway (rate limiter, generate co-relation id)
 *      9. Cloud Front (CDN)
 *          user -> edge location -> website
 *      10. Route 53  -> region
 *      11. VPC => private subnet1(ip range from xx to xx),  public subnet2(ip range from xx to xx)
 *
 *          user -> internet gateway  -> public subnet  -> (route table) -> private subnet
 *
 *
 *      12. ECS (Fargate / EC2)
 *
 *                      ECS  -> use "task definition[get docker image from ECR]" to deploy docker container
 *
 *             EC2(agent)              EC2(agent)
 *             docker1                 docker3
 *             docker2
 *
 *
 */