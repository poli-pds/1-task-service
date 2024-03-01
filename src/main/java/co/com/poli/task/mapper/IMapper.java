package co.com.poli.task.mapper;

public interface IMapper<I,O> {
    public O mapper(I in);
}
