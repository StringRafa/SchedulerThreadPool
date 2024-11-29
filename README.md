# Solução para Problemas de Concorrência em Schedulers no Spring Boot

Este projeto aborda a solução de problemas relacionados à concorrência em tarefas agendadas no Spring Boot, onde múltiplos `@Scheduled` competiam pela mesma thread do pool padrão, causando gargalos e travamentos.

## Contexto do Problema
Em sistemas com diversos schedulers, o uso de um único pool de threads pode gerar:
- **Concorrência excessiva**, com tarefas bloqueando umas às outras.
- **Travamentos** em execuções longas que impedem a execução de outras tarefas.
- **Perda de previsibilidade**, já que uma tarefa pode impactar o desempenho geral do sistema.

## Solução Implementada
A solução utiliza **executores dedicados para cada scheduler**, configurados por meio de:
1. **`@Async` com Executors Dedicados**: Cada agendador foi configurado para usar um executor específico, garantindo que as tarefas sejam processadas de forma independente.
2. **Isolamento de Tarefas**: Cada tarefa tem seu próprio executor, evitando interferências entre tarefas que possuem tempos de execução distintos.

### Exemplo de Configuração de Tarefa
```java
@Async("task1Executor")
@Scheduled(fixedDelay = 5000)
public void schedulerTask1() {
    task1Executor.execute(() -> {
        log.info("Started task1Executor {}", LocalTime.now());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
        log.info("Finished task1Executor {}", LocalTime.now());
    });
}
```

### Exemplo de Configuração de Executor Dedicado
```java
@Bean(name = "task1Executor")
public Executor task1Executor() {
    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
    executor.setCorePoolSize(1);
    executor.setMaxPoolSize(1);
    executor.setQueueCapacity(1);
    executor.setThreadNamePrefix("task1Executor-");
    executor.setRejectedExecutionHandler(new DiscardPolicy());
    executor.initialize();
    return executor;
}
```
### Benefícios da Solução
- **Eliminação de Gargalos**: Tarefas longas não bloqueiam outras tarefas, garantindo o funcionamento contínuo.
- **Isolamento de Tarefas**: Cada tarefa executa de forma independente, reduzindo impactos negativos entre elas.
- **Escalabilidade**: A adição de novas tarefas ou ajustes em tarefas existentes é simplificada, sem impactos colaterais.
- **Maior Confiabilidade**: A solução torna o sistema mais robusto e resiliente a problemas de concorrência.
Quando Utilizar?

### Essa abordagem é ideal em sistemas com:

- Tarefas agendadas de longa duração.
- Múltiplos agendadores concorrendo por recursos.
- Requisitos de escalabilidade e previsibilidade na execução de tarefas.
### Conclusão
Com a configuração de executores dedicados, a aplicação ganha em desempenho, previsibilidade e robustez, resolvendo problemas críticos de concorrência entre schedulers no Spring Boot.