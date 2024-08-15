package com.demoqa.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class CollectionBodyModel {

    String userId;

    List<IsbnModel> collectionOfIsbns;
}
