# Ubuntu and nodejs
FROM node:11
LABEL maintainer="Jose Ramirez"

# copy the regtest box files into the image
ADD . /home/node
RUN chown -R node:node  /home/node/1
RUN chown -R node:node  /home/node/2

RUN tar -xzf /home/node/bitcoin/bitcoin-0.17.1-x86_64-linux-gnu.tar.gz -C /home/node/

ENV PATH="/home/node/bitcoin-0.17.1/bin:${PATH}"

# use the node user when running the image
USER node

# run commands from inside the regtest directory
WORKDIR /home/node

# expose two rpc ports for the nodes to allow outside container access
EXPOSE 8081 8091 8082 8092 
CMD ["/bin/bash"]