#!/bin/bash
keytool -genkey -v -keystore javart.keystore -alias javart_android_publish_key -keyalg RSA -keysize 2048 -validity 10000
