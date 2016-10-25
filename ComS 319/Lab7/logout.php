<?php
/**
 * Created by PhpStorm.
 * User: Blane
 * Date: 10/24/2015
 * Time: 5:59 PM
 */

session_start();

session_destroy();

header('Location: http://localhost:8080/Lab7/login.html');
