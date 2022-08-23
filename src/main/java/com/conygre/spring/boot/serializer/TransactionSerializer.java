package com.conygre.spring.boot.serializer;

import com.conygre.spring.boot.entities.Transaction;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException;

public class TransactionSerializer extends StdSerializer<Transaction> {

    public TransactionSerializer() {
        this(null);
    }

    public TransactionSerializer(Class<Transaction> t) {
        super(t);
    }

    @Override
    public void serialize(Transaction transaction, JsonGenerator jgen, SerializerProvider serializerProvider) throws IOException {
        jgen.writeStartObject();
        jgen.writeNumberField("id", transaction.getId());
        jgen.writeStringField("stock_symbol", transaction.getStock().getSymbol());
        jgen.writeStringField("submittedDateTime", transaction.getSubmittedDateTime().toString());
        jgen.writeNumberField("submittedPrice", transaction.getSubmittedPrice());
        jgen.writeNumberField("qty", transaction.getQty());
        jgen.writeStringField("type", transaction.getType());
        jgen.writeEndObject();
    }
}
