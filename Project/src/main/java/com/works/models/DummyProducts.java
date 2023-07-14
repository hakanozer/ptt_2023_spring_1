package com.works.models;

import java.util.List;

@lombok.Data
public class DummyProducts {
    private List<DummyProduct> products;
    private Long total;
    private Long skip;
    private Long limit;
}
