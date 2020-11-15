package com.elbraulio.genetical.individual;

import com.elbraulio.genetical.Individual;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * @author Braulio Lopez (elbraulio274@gmail.com)
 */
public final class DefaultIndividual<T> implements Individual<T> {
    private final List<T> genes;
    private final String id;

    public DefaultIndividual(List<T> genes) {
        this.genes = genes;
        this.id = UUID.randomUUID().toString();
    }

    @Override
    public String id() {
        return this.id;
    }

    @Override
    public List<T> genes() {
        return this.genes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultIndividual<?> that = (DefaultIndividual<?>) o;
        return Objects.equals(genes, that.genes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(genes);
    }
}
