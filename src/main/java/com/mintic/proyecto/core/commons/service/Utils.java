package com.mintic.proyecto.core.commons.service;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.UUID;

import org.apache.commons.io.IOUtils;
import org.hashids.Hashids;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public final class Utils {

  private static final Logger logger = LoggerFactory.getLogger(Utils.class);

  public static final ObjectMapper MAPPER = new ObjectMapper();
  static {
    MAPPER.registerModule(new JavaTimeModule());
    MAPPER.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
  }

  public static String serializeObject(final Object value) {
    try {
      return MAPPER.writeValueAsString(value);
    } catch (JsonProcessingException e) {
      logger.error("Serialization Failed", e);
      return "";
    }
  }

  public static <T> T deserializeObject(final String src, final Class<T> valueType, final Class<?>... paramClass) {

    try {
      return MAPPER.readValue(src, MAPPER.getTypeFactory().constructParametricType(valueType, paramClass));
    } catch (JsonMappingException e) {
      logger.warn("Failed deserialize. source:|{}|, message error:{}, ", src, e.getMessage());
      return null;
    } catch (JsonProcessingException e) {
      logger.warn("Failed deserialize. source:|{}|, message error:{}, ", src, e.getMessage());
      return null;
    }

  }

  public static Double sbtRoundDouble(final Double value, final Integer places) {
    if (value == null || places == null || places < 0) {
      throw new IllegalArgumentException();
    }

    BigDecimal bd = BigDecimal.valueOf(value);
    bd = bd.setScale(places, RoundingMode.HALF_UP);
    return bd.doubleValue();
  }

  public static String generateIdentifier() {
    LocalDateTime localDateTime = LocalDateTime.now();
    ZonedDateTime zdt = ZonedDateTime.of(localDateTime, ZoneId.systemDefault());
    return UUID.randomUUID().toString() + "_" + zdt.toEpochSecond();
  }

  public static String generateShortIdentifier() {
    Hashids hashids = new Hashids(Utils.generateIdentifier());
    LocalDateTime localDateTime = LocalDateTime.now();
    ZonedDateTime zdt = ZonedDateTime.of(localDateTime, ZoneId.systemDefault());
    String hash = hashids.encode(1l, 2l, 3l, zdt.toEpochSecond());
    return hash + "_" + zdt.toEpochSecond();
  }

  public static String objectToJsonString(final Object object) {
    try {
      return new ObjectMapper().writeValueAsString(object);
    } catch (Exception e) {
      return e.getMessage();
    }
  }

  public static String formatDatetime(final LocalDateTime value) {
    return DateTimeFormatter.ofPattern("dd/MM/yyyy'-'HH:mm").format(value);
  }

  public static String formatFullDate(final LocalDateTime value) {
    return DateTimeFormatter.ofPattern("dd MMMM YYYY").toFormat().format(value);
  }

  public static String formatDate(final LocalDate value) {
    return DateTimeFormatter.ofPattern("dd/MM/yyyy").toFormat().format(value);
  }

  public static String formatTime(final LocalDateTime value) {
    return DateTimeFormatter.ofPattern("HH:mm").toFormat().format(value);
  }

  public static String formatDuration(final Integer value) {
    return String.format("%02d:%02d", (value / 60), (value % 60));
  }

  public static <T> T convertValue(Object fromValue, final Class<T> valueType, final Class<?>... paramClass) {
    return deserializeObject(serializeObject(fromValue), valueType, paramClass);
  }

  public static <T> T convertValue(Object fromValue, Class<T> toValueType) {
    return MAPPER.convertValue(fromValue, toValueType);
  }

  public static String encodeToBase64(InputStream input) throws IOException {
    byte[] fileOut = IOUtils.toByteArray(input);

    String fileOutB64 = Base64.getEncoder().encodeToString(fileOut);
    return fileOutB64;
  }

  public static byte[] decodeToBase64(String input) throws IOException {

    return Base64.getDecoder().decode(input);
  }

}
