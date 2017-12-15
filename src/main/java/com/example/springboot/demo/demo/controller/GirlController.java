package com.example.springboot.demo.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.springboot.demo.demo.domain.bean.Girl;
import com.example.springboot.demo.demo.domain.ro.GirlRo;
import com.example.springboot.demo.demo.domain.so.GirlSo;
import com.example.springboot.demo.demo.service.GirlService;
import com.example.springboot.demo.demo.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller
 * @author <a href="mailto:617095443@qq.com">zhuguofeng</a>
 */
@RestController
@RequestMapping("/girl")
public class GirlController {

    @Autowired
    private GirlService girlService;

    @Autowired
    private RedisUtil redisUtil;

    /**
     *
     * 创建
     * @return
     */
	/*@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addPerson(String name, Integer age, String address){

		boolean flag = true;
		String msg = null;

		if(null == name || "".equals(name)){
			flag = false;
			msg = "请填写名字！";
		}

		if(flag && null == age){
			flag = false;
			msg = "请填写年龄！";
		}

		if(flag && (null == address || "".equals(address))){
			flag = false;
			msg = "请填写地址！";
		}

		if(flag){
			Person person = new Person();
			person.setName(name);
			person.setAge(age);
			person.setAddress(address);
			personService.createPerson(person);
			msg = "创建成功！";
		}

		return msg;

	}*/


    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String addPerson(String jsonStr){

        boolean flag = true;
        String msg = null;

        if(null == jsonStr || jsonStr.isEmpty()){
            flag = false;
            msg = "json串不能为空！";
        }

        if(flag){

            Girl person = JSON.parseObject(jsonStr, Girl.class);

            if(flag && null == person.getAge()){
                flag = false;
                msg = "请填写年龄！";
            }



            if(flag){
                girlService.createGirl(person);
                msg = "创建成功！";
            }

        }

        return msg;

    }

    /**
     *
     * 修改
     * @return
     */
	/*@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updatePerson(@RequestBody Person person){

		boolean flag = true;
		String msg = null;

		if(null == person){
			flag = false;
			msg = "参数不能为空！";
		}

		if(flag && null == person.getId()){
			flag = false;
			msg = "id不能为空！";
		}

		if(flag && (null == person.getAddress() || "".equals(person.getAddress()))){
			flag = false;
			msg = "请填写地址！";
		}

		if(flag && null == person.getAge()){
			flag = false;
			msg = "年龄不能为空！";
		}

		if(flag){
			personService.updatePerson(person);
			msg = "修改成功！";
		}

		return msg;

	}*/

    @PostMapping("/update")
    public String updatePerson(@RequestParam(value = "cupSize", required = false)String cupSize, @RequestParam(value = "age", required = false)String age,@RequestParam(value = "money",required = false)String money,
                               @RequestBody(required = false) String jsonStr){

        boolean flag = true;
        String msg = null;

        if(null == jsonStr || jsonStr.isEmpty()){
            flag = false;
            msg = "参数不能为空！";
        }

        if(flag){

            Girl person = JSON.parseObject(jsonStr, Girl.class);

            if(flag && null == person.getId()){
                flag = false;
                msg = "id不能为空！";
            }

            if(flag){
                girlService.updateGirl(person);
                msg = "修改成功！";
            }

        }

        return msg;

    }



    /**
     *
     * 删除
     * @return
     */
    //@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @GetMapping("/delete/{id}")
    public String deletePerson(@PathVariable("id") Long id){

        boolean flag = true;
        String msg = null;

        if(null == id){
            flag = false;
            msg = "id不能为空！";
        }

        if(flag){
            Girl person = new Girl();
            person.setId(id);
            girlService.deleteGirl(person);
            msg = "删除成功！";
        }

        return msg;

    }

    /**
     *
     * 查询单个

     * @return
     */
    @GetMapping("/queryone/{id}")
    public GirlRo queryOneGirl(@PathVariable("id") Long id){

        boolean flag = true;
        GirlRo personRo = null;

        if(null == id){
            flag = false;
        }

        if(flag){
            GirlSo girlSo = new GirlSo();
            girlSo.setId(id);
            personRo = girlService.queryOneGirl(girlSo);
        }

        return personRo;

    }

    /**
     *
     * 查询列表

     * @return
     */
    @PostMapping("/querylist")
    public List<GirlRo> queryPersonList(@RequestParam(value = "id", required = false)Integer id , @RequestBody(required = false) String jsonStr){

        GirlSo personSo = JSON.parseObject(jsonStr, GirlSo.class);
        List<GirlRo> girlList = girlService.queryAllGirl(personSo);

        return girlList;

    }

    /**
     *
     * 存入缓存
     * @return
     */
    @GetMapping("/redis/add/{id}")
    public void addToRedis(@PathVariable("id") Long id){

        String girlKey = "my.demo.girl."+id;
        GirlSo girlSo = new GirlSo();
        girlSo.setId(id);
        GirlRo girlRo = girlService.queryOneGirl(girlSo);
        if(null != girlRo) {
            String girlJson = JSON.toJSONString(girlRo);
            redisUtil.set(girlKey, girlJson);
        }

    }

    /**
     *
     * 查询缓存
     * @return
     */
    @GetMapping("/redis/query/{id}")
    public GirlRo queryOneGirlFromRedis(@PathVariable("id") Long id){

        String girlKey = "my.demo.girl."+id;
        String girlStr = redisUtil.queryString(girlKey);

        if(null != girlStr && !"".equals(girlStr)) {
            GirlRo girlRo = JSON.parseObject(girlStr, GirlRo.class);
            return girlRo;
        }

        return null;
    }

}
